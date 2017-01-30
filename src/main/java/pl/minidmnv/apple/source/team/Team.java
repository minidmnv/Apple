package pl.minidmnv.apple.source.team;

/**
 * @author minidmnv
 */
public class Team {

    public final String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Team{");
        sb.append("teamName='").append(teamName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
