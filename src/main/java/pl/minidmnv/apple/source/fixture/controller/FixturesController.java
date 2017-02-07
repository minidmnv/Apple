package pl.minidmnv.apple.source.fixture.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.data.FixtureDetails;
import pl.minidmnv.apple.source.fixture.service.FixtureService;

/**
 * @author minidmnv
 */
@RestController
@RequestMapping("/fixtures/")
public class FixturesController {

    @Autowired private FixtureService fixtureService;

    @RequestMapping(method = GET)
    List<Fixture> getUpcomingFixtures() {
        return fixtureService.getUpcomingFixtures();
    }

    @RequestMapping(value = "{fixtureId}", method = GET)
    FixtureDetails getFixtureDetails(@PathVariable String fixtureId) {
    	return fixtureService.getFixtureDetails(fixtureId);
    }

}
