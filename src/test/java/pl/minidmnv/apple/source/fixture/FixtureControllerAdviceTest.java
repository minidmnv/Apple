package pl.minidmnv.apple.source.fixture;

import java.util.Optional;

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

import pl.minidmnv.apple.source.exception.FSConnectionException;
import pl.minidmnv.apple.source.fixture.controller.FixturesController;
import pl.minidmnv.apple.source.fixture.controller.FixturesControllerAdvice;
import pl.minidmnv.apple.source.fixture.service.FixtureService;

/**
 * @author mnicinski.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FixtureControllerAdviceTest {

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		FixturesController fixturesController = new FixturesController();
		FixtureService fixtureRepositoryMock = Mockito.mock(FixtureService.class);
		Mockito.when(fixtureRepositoryMock.getUpcomingFixtures()).thenThrow(new FSConnectionException());
		Mockito.when(fixtureRepositoryMock.getFixtureDetails("fixtureId")).thenReturn(Optional.empty());
		ReflectionTestUtils.setField(fixturesController, "fixtureService", fixtureRepositoryMock);
		mockMvc = MockMvcBuilders.standaloneSetup(fixturesController).setControllerAdvice(new FixturesControllerAdvice())
				.build();
	}

	@Test
	public void shouldFixtureRepositoryResponseStatusNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/fixtures/fixtureId"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void shouldFixtureRepositoryResponseStatusServiceUnavailable() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/fixtures/"))
				.andExpect(MockMvcResultMatchers.status().isServiceUnavailable());
	}

}
