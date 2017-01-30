package pl.minidmnv.apple.source.fixture.repository;

import java.util.Optional;

import org.jsoup.nodes.Document;

/**
 * @author mnicinski.
 */
public interface FixtureRepository {

	Optional<Document> getUpcomingFixturesDocument();

}
