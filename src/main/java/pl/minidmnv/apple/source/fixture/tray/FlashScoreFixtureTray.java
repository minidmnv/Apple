package pl.minidmnv.apple.source.fixture.tray;

import java.io.IOException;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author mnicinski.
 */
public class FlashScoreFixtureTray implements FixtureTray {

	@Override
	public Optional<Document> getUpcomingFixturesDocument() {
		Document siteDocument = null;
		try {
			 siteDocument = Jsoup.connect("http://www.flashscore.pl/pilka-nozna/polska/ekstraklasa/spotkania/").get();
		} catch (IOException e) {
			System.out.println("Wystąpił błąd podczas połączenia FlashScore");
		}

		return Optional.ofNullable(siteDocument);
	}

}
