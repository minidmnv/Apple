package pl.minidmnv.apple.source.fixture.data;

import java.time.LocalDateTime;

/**
 * @author minidmnv
 */
public class FixtureResult {

	private final String competition;
	private final String homeTeam;
	private final String awayTeam;
	private final Integer homeScore;
	private final Integer awayScore;
	private final LocalDateTime date;

	public FixtureResult(String competition, String homeTeam, String awayTeam, Integer homeScore, Integer awayScore, LocalDateTime date) {
		this.competition = competition;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.date = date;
	}

}
