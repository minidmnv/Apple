package pl.minidmnv.apple.source.fixture.data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author mnicinski.
 */
public final class FixtureDetails implements Serializable {

    private List<FixtureResult> headFixtureResults;

    public FixtureDetails(List<FixtureResult> headFixtureResults) {
        this.headFixtureResults = headFixtureResults;
    }

    public List<FixtureResult> getHeadFixtureResults() {
        return Collections.unmodifiableList(headFixtureResults);
    }
}
