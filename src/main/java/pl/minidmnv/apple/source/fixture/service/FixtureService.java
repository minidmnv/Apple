package pl.minidmnv.apple.source.fixture.service;

import java.util.List;
import java.util.Optional;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;

/**
 * @author mnicinski.
 */
public interface FixtureService {

	List<Fixture> getUpcomingFixtures();

	Optional<FixtureDetails> getFixtureDetails(String fixtureId);
}
