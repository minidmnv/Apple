package pl.minidmnv.apple.source.fixture.repository;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.minidmnv.apple.source.exception.FSConnectionException;

/**
 * @author mnicinski.
 */
@Repository
public class FSFixtureRepository implements FixtureRepository {

	private static final Logger log = LoggerFactory.getLogger(FSFixtureRepository.class);
	private static final String ROOT_URL = "http://www.flashscore.pl/";

	@Override public Optional<Document> getUpcomingFixturesDocument() {
		return getSiteDocument(ROOT_URL + "pilka-nozna/polska/ekstraklasa/spotkania/");
	}

	@Override
	public Optional<Document> getFixtureHeadDetails(String fixtureId) {
		return getSiteDocument(MessageFormat.format(ROOT_URL + "mecz/{0}/#h2h;overall", fixtureId));
	}

	private Optional<Document> getSiteDocument(String url) {
		log.info("url: " + url);
		Document siteDocument = null;
		try {
			siteDocument = Jsoup.connect(url).get();
		} catch (Exception e) {
			log.error("Wystąpił błąd podczas połączenia FlashScore", e);
			throw new FSConnectionException();
		}

		log.debug("Zwracam odpowiedź: " + siteDocument.outerHtml());
		return Optional.ofNullable(siteDocument);
	}

}
