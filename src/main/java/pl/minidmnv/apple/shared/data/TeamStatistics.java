package pl.minidmnv.apple.shared.data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mnicinski.
 */
public final class TeamStatistics implements Serializable {

    private final List<Goal> scoredGoals;
    private final List<Goal> concededGoals;
    private final Integer ballPossession;
    private final Integer fouls;
    private final List<Card> cards;
    private final Integer goalAttempts;
    private final Integer shotsOnGoal;
    private final Integer shotsOffGoal;
    private final Integer blockedShots;
    private final Integer freeKicks;
    private final Integer cornerKicks;
    private final Integer offsides;
    private final Integer goalkeeperSaves;


    public TeamStatistics(List<Goal> scoredGoals, List<Goal> concededGoals, Integer ballPossession, Integer fouls,
                          List<Card> cards, Integer goalAttempts, Integer shotsOnGoal, Integer shotsOffGoal,
                          Integer blockedShots, Integer freeKicks, Integer cornerKicks, Integer offsides,
                          Integer goalkeeperSaves) {
        this.scoredGoals = scoredGoals;
        this.concededGoals = concededGoals;
        this.ballPossession = ballPossession;
        this.fouls = fouls;
        this.cards = cards;
        this.goalAttempts = goalAttempts;
        this.shotsOnGoal = shotsOnGoal;
        this.shotsOffGoal = shotsOffGoal;
        this.blockedShots = blockedShots;
        this.freeKicks = freeKicks;
        this.cornerKicks = cornerKicks;
        this.offsides = offsides;
        this.goalkeeperSaves = goalkeeperSaves;
    }
}
