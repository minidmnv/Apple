package pl.minidmnv.apple.source.fixture.service.parser;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.minidmnv.apple.source.fixture.data.FixtureResult;
import pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElementPicker;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author minidmnv
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FSFixtureParserTest {

    private static final String RESOURCES_ROOT_PATH = "src/test/resources/";
    private static final String FIXTURE_DETAILS_DIR = "source/fixture/details/";
    private static final String FULL_POL1_FIXTURE_DETAIL = "full_POL1_fixture_detail.txt";

    private FSFixtureParser parser;

    @Before
    public void setUp() {
        parser = new FSFixtureParser(new FSFixtureDOMElementPicker());
    }

    @Test
    public void shouldReturnProperFixtureResultHomeScore() throws IOException {
        FixtureResult fixtureResult = parser.transformDomResult(getFullFixtureDetailElement());
        assertEquals(new Integer(0), fixtureResult.getHomeScore());
    }

    @Test
    public void shouldReturnProperFixtureResultAwayScore() throws IOException {
        FixtureResult fixtureResult = parser.transformDomResult(getFullFixtureDetailElement());
        assertEquals(new Integer(0), fixtureResult.getAwayScore());
    }

    @Test
    public void shouldReturnProperFixtureResultHomeTeam() throws IOException {
        FixtureResult fixtureResult = parser.transformDomResult(getFullFixtureDetailElement());
        assertEquals("Zagłębie Lubin", fixtureResult.getHomeTeam().getName());
    }

    @Test
    public void shouldReturnProperFixtureResultAwayTeam() throws IOException {
        FixtureResult fixtureResult = parser.transformDomResult(getFullFixtureDetailElement());
        assertEquals("MTK Budapest", fixtureResult.getAwayTeam().getName());
    }

    @Test
    public void shouldReturnProperFixtureResultCompetition() throws IOException {
        FixtureResult fixtureResult = parser.transformDomResult(getFullFixtureDetailElement());
        assertEquals("Międzyklubowe towarzyskie (Świat)", fixtureResult.getCompetition());
    }

    private Element getFullFixtureDetailElement() throws IOException {
        Element result = new Element(Tag.valueOf("td"), "");
        result.append(new String(
                Files.readAllBytes(FileSystems.getDefault().getPath(
                                RESOURCES_ROOT_PATH + FIXTURE_DETAILS_DIR + FULL_POL1_FIXTURE_DETAIL)),
                "UTF8"));
        return result;
    }


}
