package pl.minidmnv.apple.source.fixture.service.parser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.data.FixtureResult;
import pl.minidmnv.apple.source.team.data.Team;

/**
 * @author mnicinski.
 */
@Component
public class FSFixtureParser {

	private static final Logger log = LoggerFactory.getLogger(FSFixtureParser.class);

	private static final String HOME_TEAM_PARAM = "CX÷";
	private static final String AWAY_TEAM_PARAM = "AF÷";
	private static final String DATE_PARAM = "AD÷";
	private static final String COMPETITION_TITLE = "title=\"";
	private static final String DATE_END_PARAM = "</span";
	private static final String DATE_BEGIN_PARAM = "date\">";
	private static final String TEAM_PARAM_END = "span>";
	private static final String TEAM_PARAM = "name\"><" + TEAM_PARAM_END;
	private static final String STRONG_LAB_REGEX = "</?strong>";

	private int findIndexOfParameter(String parameter, String elem, int elemIndex) {
		return elem.indexOf(parameter, elemIndex) + parameter.length();
	}

	private int findIndexOfParameter(String parameter, String elem) {
		return findIndexOfParameter(parameter, elem, 0);
	}

	private int getIndexOfParameterEnding(String elem, int elemIndex) {
		return findIndexOfParameter("¬", elem, elemIndex) - 1;
	}

	public Fixture transformStageScheduledElementToFixture(String elem) {
		log.info(elem);

		String detailsId = elem.substring(1, getIndexOfParameterEnding(elem, 0));

		int elemIndex = findIndexOfParameter(DATE_PARAM, elem);
		LocalDateTime date =
				Instant.ofEpochSecond(Long.valueOf(
						elem.substring(elemIndex, getIndexOfParameterEnding(elem, elemIndex))))
						.atZone(ZoneId.systemDefault())
						.toLocalDateTime();
		elemIndex = findIndexOfParameter(HOME_TEAM_PARAM, elem);
		Team homeTeam = new Team(elem.substring(elemIndex,
				getIndexOfParameterEnding(elem, elemIndex)));

		elemIndex = findIndexOfParameter(AWAY_TEAM_PARAM, elem);
		Team awayTeam = new Team(elem.substring(elemIndex,
				getIndexOfParameterEnding(elem, elemIndex)));

		return new Fixture(homeTeam, awayTeam, date, detailsId);
	}

	//TODO: przerobic na korzystanie z pickera
	public FixtureResult transformDomResult(Element elem) {
		String resultsHtml = elem.html();
		log.debug("domResult: " + resultsHtml);

		LocalDateTime date = Instant.ofEpochSecond(
				Long.valueOf(resultsHtml.substring(findIndexOfParameter(DATE_BEGIN_PARAM, resultsHtml),
						findIndexOfParameter(DATE_END_PARAM, resultsHtml) - DATE_END_PARAM.length())))
				.atZone(ZoneId.systemDefault()).toLocalDateTime();
		int elemIndex = findIndexOfParameter(COMPETITION_TITLE, resultsHtml);
		String competition =  resultsHtml.substring(elemIndex, findIndexOfParameter("\"", resultsHtml,
				elemIndex));

		//TODO: dokonczyc implementacje wyciagania pozostalych elementow - druzyn, oraz wynikow
		elemIndex = findIndexOfParameter(TEAM_PARAM, resultsHtml);
		Team homeTeam = new Team(cutOutStrongLab(resultsHtml.substring(elemIndex,
				findIndexOfParameter(TEAM_PARAM_END, resultsHtml, elemIndex) - (TEAM_PARAM_END.length() + 2))));
		elemIndex = findIndexOfParameter(TEAM_PARAM, resultsHtml, elemIndex);
		Team awayTeam = new Team(cutOutStrongLab(resultsHtml.substring(elemIndex,
				findIndexOfParameter(TEAM_PARAM_END, resultsHtml, elemIndex) - (TEAM_PARAM_END.length() + 2))));
		Integer homeScore = 1;
		Integer awayScore = 0;

		return new FixtureResult(competition, homeTeam, awayTeam, homeScore, awayScore, date);
	}

	private String cutOutStrongLab(String text) {
		return text.replaceAll(STRONG_LAB_REGEX, "");
	}

}
