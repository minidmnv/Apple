package pl.minidmnv.apple.source.fixture.data;

import pl.minidmnv.apple.source.team.data.Team;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author minidmnv
 */
public class FixtureResult implements Serializable {

	private final String competition;
	private final Team homeTeam;
	private final Team awayTeam;
	private final Integer homeScore;
	private final Integer awayScore;
	private final LocalDateTime date;
	private final String fixtureDetails;

	public FixtureResult(String competition, Team homeTeam, Team awayTeam, Integer homeScore, Integer awayScore, LocalDateTime date, String fixtureDetails) {
		this.competition = competition;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.date = date;
		this.fixtureDetails = fixtureDetails;
	}

	public String getCompetition() {
		return competition;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public Integer getHomeScore() {
		return homeScore;
	}

	public Integer getAwayScore() {
		return awayScore;
	}

	public LocalDateTime getDate() {
		return date;
	}
}
