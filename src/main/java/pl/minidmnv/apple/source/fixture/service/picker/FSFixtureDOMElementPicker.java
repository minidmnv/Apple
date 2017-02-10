package pl.minidmnv.apple.source.fixture.service.picker;

import static pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElement.FIXTURE_RESULT_TR_CLASS;
import static pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElement.UPCOMING_FIXTURES_DIV_ID;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

/**
 * @author minidmnv
 */
@Component
public class FSFixtureDOMElementPicker {

    private Element payload;

    public void init(Element doc) {
        this.payload = doc;
    }

    public Element pickUpcomingFixtures() {
        return payload.getElementById(UPCOMING_FIXTURES_DIV_ID.elementName);
    }

	public Elements pickFixtureHeadResults() {
		return payload.getElementsByClass(FIXTURE_RESULT_TR_CLASS.elementName);
	}
}
