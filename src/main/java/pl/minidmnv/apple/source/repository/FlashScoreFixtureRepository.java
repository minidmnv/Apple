package pl.minidmnv.apple.source.repository;

import java.util.List;

import org.jsoup.nodes.Document;

import pl.minidmnv.apple.data.Fixture;
import pl.minidmnv.apple.source.tray.FixtureTray;

/**
 * @author mnicinski.
 */
public class FlashScoreFixtureRepository implements FixtureRepository {

	private FixtureTray fixtureTray;

	@Override
	public List<Fixture> getUpcomingFixtures(Integer limit) {
		Document upcomingFixturesDocument = fixtureTray.getUpcomingFixturesDocument();



		return null;
	}
}
