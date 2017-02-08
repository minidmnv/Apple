package pl.minidmnv.apple.source.fixture.repository;

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
	private static final String ROOT_FEED_URL = "http://d.flashscore.pl/x/feed/";

	@Override public Optional<Document> getUpcomingFixturesDocument() {
		return getSiteDocument(ROOT_URL + "pilka-nozna/polska/ekstraklasa/spotkania/");
	}

	@Override
	public Optional<Document> getFixtureHeadDetails(String fixtureId) {
		return getSiteDocument(MessageFormat.format(ROOT_FEED_URL + "d_hh_{0}_pl_1", fixtureId));
	}

	private Optional<Document> getSiteDocument(String url) {
		log.info("url: " + url);
		Document siteDocument;
		try {
			siteDocument = Jsoup.connect(url)
					.referrer("http://d.flashscore.pl/x/feed/proxy-local")
					.header("X-Fsign", "SW9D1eZo")
					.get();
		} catch (Exception e) {
			log.error("Wystąpił błąd podczas połączenia FlashScore", e);
			throw new FSConnectionException();
		}

		log.debug("Zwracam odpowiedź: " + siteDocument.outerHtml());
		return Optional.of(siteDocument);
	}

}
