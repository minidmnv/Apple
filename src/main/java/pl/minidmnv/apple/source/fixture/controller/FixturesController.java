package pl.minidmnv.apple.source.fixture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.service.FixtureService;

/**
 * @author minidmnv
 */
@RestController
@RequestMapping("/fixtures/")
public class FixturesController {

    private static final Integer MAX_LIMIT = 25;

    @Autowired private FixtureService fixtureService;

    @RequestMapping(method = RequestMethod.GET)
    List<Fixture> getUpcomingFixtures() {
        return fixtureService.getUpcomingFixtures();
    }

}
