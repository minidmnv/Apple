package pl.minidmnv.apple.source.fixture.service;

import java.util.List;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;

/**
 * @author mnicinski.
 */
public interface FixtureService {

	List<Fixture> getUpcomingFixtures();

	FixtureDetails getFixtureDetails(String fixtureId);
}
