package pl.minidmnv.apple.source.fixture.data;

import pl.minidmnv.apple.source.team.data.Team;

import java.time.LocalDateTime;

/**
 * @author minidmnv
 */
public class Fixture {

    public final Team homeTeam;
    public final Team awayTeam;
    public final LocalDateTime date;
    public final String detailsId;

    public Fixture(Team homeTeam, Team awayTeam, LocalDateTime date, String detailsId) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.detailsId = detailsId;
    }

}
