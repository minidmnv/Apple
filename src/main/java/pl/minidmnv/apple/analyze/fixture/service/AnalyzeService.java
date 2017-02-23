package pl.minidmnv.apple.analyze.fixture.service;

import pl.minidmnv.apple.analyze.fixture.data.FixtureAnalyzeResult;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;

/**
 * @author mnicinski.
 */
public interface AnalyzeService {

	FixtureAnalyzeResult analyzeFixture(FixtureDetails details);

}
