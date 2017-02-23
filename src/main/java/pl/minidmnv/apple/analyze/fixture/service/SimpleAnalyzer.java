package pl.minidmnv.apple.analyze.fixture.service;

import org.springframework.stereotype.Service;

import pl.minidmnv.apple.analyze.fixture.data.FixtureAnalyzeResult;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;

/**
 * @author mnicinski.
 */
@Service
public class SimpleAnalyzer implements AnalyzeService {

	@Override
	public FixtureAnalyzeResult analyzeFixture(FixtureDetails details) {
		return null;
	}

}
