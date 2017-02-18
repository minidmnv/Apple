package pl.minidmnv.apple.source.fixture.service.parser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.data.FixtureResult;
import pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElementPicker;
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

	@Autowired private FSFixtureDOMElementPicker picker;

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

	public FixtureResult transformDomResult(Element elem) {
		picker.init(elem);

		LocalDateTime date = picker.pickFixtureDate();
		String competition = picker.pickFixtureCompetition();
		Team homeTeam = picker.pickFixtureHomeTeam();
		Team awayTeam = picker.pickFixtureAwayTeam();
		Integer homeScore = picker.pickFixtureHomeScore();
		Integer awayScore = picker.pickFixtureAwayScore();

		return new FixtureResult(competition, homeTeam, awayTeam, homeScore, awayScore, date);
	}

}
