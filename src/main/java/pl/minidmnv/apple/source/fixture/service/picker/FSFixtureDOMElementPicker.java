package pl.minidmnv.apple.source.fixture.service.picker;

import static pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElement.FIXTURE_RESULT_TR_CLASS;
import static pl.minidmnv.apple.source.fixture.service.picker.FSFixtureDOMElement.UPCOMING_FIXTURES_DIV_ID;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import pl.minidmnv.apple.source.team.data.Team;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

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

    public LocalDateTime pickFixtureDate() {
        return Instant.ofEpochSecond(
                Long.valueOf(payload.getElementsByClass("date").text()))
                        .atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public Team pickFixtureHomeTeam() {
        return new Team(payload.getElementsByClass("name").first().text());
    }

    public Team pickFixtureAwayTeam() {
        return new Team(payload.getElementsByClass("name").last().text());
    }

    public String pickFixtureCompetition() {
        return payload.getElementsByClass("flag_td").attr("title");
    }

    public Integer pickFixtureHomeScore() {
        return Integer.valueOf(payload.getElementsByClass("score").text().substring(0, 1));
    }

    public Integer pickFixtureAwayScore() {
        return Integer.valueOf(payload.getElementsByClass("score").text().substring(4, 5));
    }
}
