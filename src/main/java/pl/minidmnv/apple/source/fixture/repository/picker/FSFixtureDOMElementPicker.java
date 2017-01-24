package pl.minidmnv.apple.source.fixture.repository.picker;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import static pl.minidmnv.apple.source.fixture.repository.picker.FSFixtureDOMElement.UPCOMING_FIXTURES_CLASS;

/**
 * @author minidmnv
 */
public class FSFixtureDOMElementPicker {

    private Document payload;

    public void init(Document doc) {
        this.payload = doc;
    }

    public Elements pickUpcomingFixtures() {
        return payload.getElementsByClass(UPCOMING_FIXTURES_CLASS.elementName);
    }

}
