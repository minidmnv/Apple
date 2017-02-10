package pl.minidmnv.apple.source.fixture.data;

import java.time.LocalDateTime;

import pl.minidmnv.apple.source.team.data.Team;

/**
 * @author minidmnv
 */
public class Fixture {

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

}
