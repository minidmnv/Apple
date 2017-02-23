package pl.minidmnv.apple.analyze.fixture.service;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.minidmnv.apple.analyze.fixture.data.FixtureAnalyzeResult;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;

/**
 * @author mnicinski.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleAnalyzerTest {

	private AnalyzeService analyzeService;

	@Before
	public void setUp() {
		analyzeService = new SimpleAnalyzer();
	}

	@Test
	public void shouldReturnEmptyAnalysis() {
		FixtureAnalyzeResult fixtureAnalyzeResult = analyzeService.analyzeFixture(new FixtureDetails(new ArrayList<>()));

	}

}