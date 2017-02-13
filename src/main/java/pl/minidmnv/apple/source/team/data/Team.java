package pl.minidmnv.apple.source.team.data;

import java.io.Serializable;

/**
 * @author minidmnv
 */
public class Team implements Serializable{

    public final String name;

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Team{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
