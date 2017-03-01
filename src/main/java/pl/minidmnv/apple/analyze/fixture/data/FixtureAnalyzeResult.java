package pl.minidmnv.apple.analyze.fixture.data;

import pl.minidmnv.apple.shared.data.TeamStatistics;

import java.io.Serializable;

/**
 * @author mnicinski.
 */
public final class FixtureAnalyzeResult implements Serializable {

	private final TeamStatistics headTeamStatistics;
	private final TeamStatistics awayTeamStatistics;
	private final FixtureCrossAnalysis crossAnalysis;

	public FixtureAnalyzeResult(TeamStatistics headTeamStatistics,
								TeamStatistics awayTeamStatistics, FixtureCrossAnalysis crossAnalysis) {
		this.headTeamStatistics = headTeamStatistics;
		this.awayTeamStatistics = awayTeamStatistics;
		this.crossAnalysis = crossAnalysis;
	}

	public TeamStatistics getHeadTeamStatistics() {
		return headTeamStatistics;
	}

	public TeamStatistics getAwayTeamStatistics() {
		return awayTeamStatistics;
	}

	public FixtureCrossAnalysis getCrossAnalysis() {
		return crossAnalysis;
	}
}
