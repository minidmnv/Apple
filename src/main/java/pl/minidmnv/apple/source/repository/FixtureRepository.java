package pl.minidmnv.apple.source.repository;

import java.util.List;

import pl.minidmnv.apple.data.Fixture;

/**
 * @author mnicinski.
 */
public interface FixtureRepository {

	List<Fixture> getUpcomingFixtures(Integer limit);

}
