package pl.minidmnv.apple.analyze.fixture.data;

import pl.minidmnv.apple.shared.data.TeamStatistics;

import java.io.Serializable;

/**
 * @author mnicinski.
 */
public final class FixtureCrossAnalysis implements Serializable {

    //te statystyki mają się ni jak do tego co zostało tu przekazane
    private final TeamStatistics headTeamStatistics;
    private final TeamStatistics awayTeamStatistics;

    public FixtureCrossAnalysis(TeamStatistics headTeamStatistics, TeamStatistics awayTeamStatistics) {
        this.headTeamStatistics = headTeamStatistics;
        this.awayTeamStatistics = awayTeamStatistics;
    }
}
