package pl.minidmnv.apple.source.fixture.controller;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.minidmnv.apple.source.fixture.controller.FixturesController;
import pl.minidmnv.apple.source.fixture.controller.FixturesControllerAdvice;
import pl.minidmnv.apple.source.fixture.service.FixtureService;

/**
 * @author mnicinski.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FixtureControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		FixturesController fixturesController = new FixturesController();
		FixtureService fixtureRepositoryMock = Mockito.mock(FixtureService.class);
		Mockito.when(fixtureRepositoryMock.getUpcomingFixtures()).thenReturn(new ArrayList<>());
		ReflectionTestUtils.setField(fixturesController, "fixtureService", fixtureRepositoryMock);
		mockMvc = MockMvcBuilders.standaloneSetup(fixturesController).setControllerAdvice(new FixturesControllerAdvice())
				.build();
	}

	@Test
	public void shouldFixtureListResponseStatusOk() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/fixtures/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
