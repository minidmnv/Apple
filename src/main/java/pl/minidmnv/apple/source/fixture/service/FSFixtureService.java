package pl.minidmnv.apple.source.fixture.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;
import pl.minidmnv.apple.source.fixture.data.FixtureResult;
import pl.minidmnv.apple.source.fixture.repository.FixtureRepository;
import pl.minidmnv.apple.source.fixture.service.parser.FSFixtureParser;
import pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElementPicker;

/**
 * @author mnicinski.
 */
@Service
public class FSFixtureService implements FixtureService {

	private static final Logger log = LoggerFactory.getLogger(FSFixtureService.class);

	private static final String FIXTURE_PARAM = "AA";

	@Autowired private FixtureRepository fixtureRepository;
	@Autowired private FSFixtureDOMElementPicker picker;
	@Autowired private FSFixtureParser parser;

	@Override public List<Fixture> getUpcomingFixtures() {
		List fixtures = new ArrayList();
		Optional<Document> upcomingFixturesDocument = fixtureRepository.getUpcomingFixturesDocument();

		if (upcomingFixturesDocument.isPresent()) {
			fixtures = parseFixtures(upcomingFixturesDocument.get());
		}

		return fixtures;
	}

	@Override public Optional<FixtureDetails> getFixtureDetails(String fixtureId) {
		FixtureDetails fixtureDetails = null;
		Optional<Document> fixtureHeadDetailsDocument = fixtureRepository.getFixtureHeadDetails(fixtureId);

		if (fixtureHeadDetailsDocument.isPresent()) {
			fixtureDetails = new FixtureDetails(parseFixtureHeadDetails(fixtureHeadDetailsDocument.get()));
		}

		return Optional.ofNullable(fixtureDetails);
	}

	private List<FixtureResult> parseFixtureHeadDetails(Document doc) {
		log.debug("ParseFixtureHeadResults - start: " + doc.ownText());
		picker.init(doc);

		return picker.pickFixtureHeadResults()
				.stream()
				.map(parser::transformDomResult)
				.collect(Collectors.toList());
	}

	private List parseFixtures(Document doc) {
		log.debug("parseFixtures - start");
		picker.init(doc);
		Element encryptedUpcomingFixtures = picker.pickUpcomingFixtures();

		return Arrays.stream(encryptedUpcomingFixtures.ownText().split(FIXTURE_PARAM))
				.skip(1)
				.map(parser::transformStageScheduledElementToFixture)
				.collect(Collectors.toList());
	}

}
