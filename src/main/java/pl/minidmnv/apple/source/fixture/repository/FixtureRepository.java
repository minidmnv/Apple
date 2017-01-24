package pl.minidmnv.apple.source.fixture.repository;

import java.util.List;

import pl.minidmnv.apple.source.fixture.data.Fixture;

/**
 * @author mnicinski.
 */
public interface FixtureRepository {

	List<Fixture> getUpcomingFixtures(Integer limit);

}
