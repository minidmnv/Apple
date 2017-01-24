package pl.minidmnv.apple.source.fixture.tray;

import java.util.Optional;

import org.jsoup.nodes.Document;

/**
 * @author mnicinski.
 */
public interface FixtureTray {

	Optional<Document> getUpcomingFixturesDocument();

}
