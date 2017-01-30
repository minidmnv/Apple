package pl.minidmnv.apple.source.fixture.service.picker;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import static pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElement.UPCOMING_FIXTURES_DIV_ID;

/**
 * @author minidmnv
 */
@Component
public class FSFixtureDOMElementPicker {

    private Document payload;

    public void init(Document doc) {
        this.payload = doc;
    }

    public Element pickUpcomingFixtures() {
        return payload.getElementById(UPCOMING_FIXTURES_DIV_ID.elementName);
    }

}
