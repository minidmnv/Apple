package pl.minidmnv.apple.analyze.fixture.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.minidmnv.apple.source.fixture.controller.FixturesControllerAdvice;

/**
 * @author mnicinski.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FixturesAnalyzeControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		FixturesAnalyzeController fixturesAnalyzeController = new FixturesAnalyzeController();
		mockMvc = MockMvcBuilders.standaloneSetup(fixturesAnalyzeController).setControllerAdvice(new FixturesControllerAdvice())
				.build();
	}

	@Test
	public void fixtureAnalyzeShouldReturnOkStatus() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/analyze/fixtures/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


}
