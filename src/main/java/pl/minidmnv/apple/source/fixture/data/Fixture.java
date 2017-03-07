package pl.minidmnv.apple.source.fixture.data;

import java.io.Serializable;
import java.time.LocalDateTime;

import pl.minidmnv.apple.source.team.data.Team;

/**
 * @author minidmnv
 */
public final class Fixture implements Serializable {

    private final Team homeTeam;
    private final Team awayTeam;
    private final LocalDateTime date;
    private final String detailsId;

    public Fixture(Team homeTeam, Team awayTeam, LocalDateTime date, String detailsId) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.detailsId = detailsId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDetailsId() {
        return detailsId;
    }
}
