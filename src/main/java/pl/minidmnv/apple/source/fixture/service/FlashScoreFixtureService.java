package pl.minidmnv.apple.source.fixture.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElementPicker;
import pl.minidmnv.apple.source.fixture.repository.FixtureRepository;
import pl.minidmnv.apple.source.team.Team;

/**
 * @author mnicinski.
 */
@Service
public class FlashScoreFixtureService implements FixtureService {

	private static final Logger log = LoggerFactory.getLogger(FlashScoreFixtureService.class);

	private static final String HOME_TEAM_PARAM = "CX÷";
	private static final String AWAY_TEAM_PARAM = "AF÷";
	private static final String DATE_PARAM = "AD÷";
	private static final String FIXTURE_PARAM = "AA";

	@Autowired private FixtureRepository fixtureRepository;
	@Autowired private FSFixtureDOMElementPicker picker;

	@Override public List<Fixture> getUpcomingFixtures(Integer limit) {
		List fixtures = new ArrayList();
		Optional<Document> upcomingFixturesDocument = fixtureRepository.getUpcomingFixturesDocument();

		if (upcomingFixturesDocument.isPresent()) {
			Document doc = upcomingFixturesDocument.get();

			fixtures = parseFixtures(doc);
		}

		return fixtures;
	}

	private List parseFixtures(Document doc) {
		log.debug("parseFixtures - start");
		picker.init(doc);
		Element encryptedUpcomingFixtures = picker.pickUpcomingFixtures();

		return Arrays.stream(encryptedUpcomingFixtures.ownText().split(FIXTURE_PARAM))
				.skip(1)
				.map(this::transformStageScheduledElementToFixture)
				.collect(Collectors.toList());
	}

	private Fixture transformStageScheduledElementToFixture(String elem) {
		log.info(elem.toString());

		String detailsId = elem.substring(1, getIndexOfParameterEnding(elem, 0));

		int elemIndex = findIndexOfParameter(DATE_PARAM, elem);
		LocalDateTime date =
				Instant.ofEpochSecond(Long.valueOf(
						elem.substring(elemIndex + DATE_PARAM.length(), getIndexOfParameterEnding(elem, elemIndex))))
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
		elemIndex = findIndexOfParameter(HOME_TEAM_PARAM, elem);
		Team homeTeam = new Team(elem.substring(elemIndex + HOME_TEAM_PARAM.length(),
				getIndexOfParameterEnding(elem, elemIndex)));

		elemIndex = findIndexOfParameter(AWAY_TEAM_PARAM, elem);
		Team awayTeam = new Team(elem.substring(elemIndex + AWAY_TEAM_PARAM.length(),
				getIndexOfParameterEnding(elem, elemIndex)));;

		return Fixture.of(homeTeam, awayTeam, date, detailsId);
	}

	private int findIndexOfParameter(String parameter, String elem, int elemIndex) {
		return elem.indexOf(parameter, elemIndex);
	}

	private int findIndexOfParameter(String parameter, String elem) {
		return findIndexOfParameter(parameter, elem, 0);
	}

	private int getIndexOfParameterEnding(String elem, int elemIndex) {
		return findIndexOfParameter("¬", elem, elemIndex);
	}
}
