package pl.minidmnv.apple.source.fixture.repository;

import java.io.IOException;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author mnicinski.
 */
@Repository
public class FSFixtureRepository implements FixtureRepository {

	private static final Logger log = LoggerFactory.getLogger(FSFixtureRepository.class);

	@Override public Optional<Document> getUpcomingFixturesDocument() {
		Document siteDocument = null;
		try {
			 siteDocument = Jsoup.connect("http://www.flashscore.pl/pilka-nozna/polska/ekstraklasa/spotkania/").get();
		} catch (IOException e) {
			log.error("Wystąpił błąd podczas połączenia FlashScore", e);
		}

		log.debug("Zwracam odpowiedź: " + siteDocument.outerHtml());
		return Optional.ofNullable(siteDocument);
	}

}
