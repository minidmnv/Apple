package pl.minidmnv.apple.analyze.fixture.data;

/**
 * @author mnicinski.
 */
public final class FixtureAnalyzeResult {

	private final TeamFixtureAnalysis headTeamFixtureAnalysis;
	private final TeamFixtureAnalysis awayTeamFixtureAnalysis;
	private final FixtureCrossAnalysis crossAnalysis;

	public FixtureAnalyzeResult(TeamFixtureAnalysis headTeamFixtureAnalysis,
	                            TeamFixtureAnalysis awayTeamFixtureAnalysis, FixtureCrossAnalysis crossAnalysis) {
		this.headTeamFixtureAnalysis = headTeamFixtureAnalysis;
		this.awayTeamFixtureAnalysis = awayTeamFixtureAnalysis;
		this.crossAnalysis = crossAnalysis;
	}

	public TeamFixtureAnalysis getHeadTeamFixtureAnalysis() {
		return headTeamFixtureAnalysis;
	}

	public TeamFixtureAnalysis getAwayTeamFixtureAnalysis() {
		return awayTeamFixtureAnalysis;
	}

	public FixtureCrossAnalysis getCrossAnalysis() {
		return crossAnalysis;
	}
}
