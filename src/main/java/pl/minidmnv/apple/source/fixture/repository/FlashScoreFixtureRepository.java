package pl.minidmnv.apple.source.fixture.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.repository.picker.FSFixtureDOMElementPicker;
import pl.minidmnv.apple.source.fixture.tray.FixtureTray;

/**
 * @author mnicinski.
 */
public class FlashScoreFixtureRepository implements FixtureRepository {

	private FixtureTray fixtureTray;
	private FSFixtureDOMElementPicker picker = new FSFixtureDOMElementPicker();

	@Override
	public List<Fixture> getUpcomingFixtures(Integer limit) {
		List fixtures = new ArrayList();
		Optional<Document> upcomingFixturesDocument = fixtureTray.getUpcomingFixturesDocument();

		if (upcomingFixturesDocument.isPresent()) {
			Document doc = upcomingFixturesDocument.get();
			picker.init(doc);
			fixtures = parseFixtures(doc);
		}

		return fixtures;
	}

	private List parseFixtures(Document document) {
		Elements elements = picker.pickUpcomingFixtures();
		return null;
	}
}
