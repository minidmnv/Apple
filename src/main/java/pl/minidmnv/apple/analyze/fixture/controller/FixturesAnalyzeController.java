package pl.minidmnv.apple.analyze.fixture.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.minidmnv.apple.analyze.fixture.data.FixtureAnalyzeResult;
import pl.minidmnv.apple.analyze.fixture.service.AnalyzeService;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;

/**
 * @author mnicinski.
 */
@RestController
@RequestMapping("/api/analyze/fixtures/")
public class FixturesAnalyzeController {

	@Autowired
	private AnalyzeService service;

	@RequestMapping(method = POST)
	public FixtureAnalyzeResult analyzeFixture(@RequestParam FixtureDetails fixture) {
		return null;
	}
}
