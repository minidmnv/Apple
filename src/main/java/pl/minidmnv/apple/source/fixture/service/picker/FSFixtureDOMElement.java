package pl.minidmnv.apple.source.fixture.service.picker;

/**
 * @author minidmnv
 */
public enum FSFixtureDOMElement {

    UPCOMING_FIXTURES_DIV_ID("tournament-page-data-fixtures"),
    FIXTURE_RESULT_TR_CLASS("highlight");

    public final String elementName;

    FSFixtureDOMElement(String elementName) {
        this.elementName = elementName;
    }


}
