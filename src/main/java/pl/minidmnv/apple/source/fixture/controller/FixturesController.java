package pl.minidmnv.apple.source.fixture.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.minidmnv.apple.source.fixture.data.Fixture;
import pl.minidmnv.apple.source.fixture.repository.FixtureRepository;

/**
 * @author minidmnv
 */
@RestController
@RequestMapping("/fixtures")
public class FixturesController {

    private static final Integer MAX_LIMIT = 25;

    private FixtureRepository fixtureRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/limit={limit}")
    List<Fixture> getUpcomingFixtures(@PathVariable Integer limit) {
        return fixtureRepository.getUpcomingFixtures(declareLimit(limit));
    }

    private Integer declareLimit(Integer limit) {
        return limit > MAX_LIMIT ? MAX_LIMIT : limit;
    }
}
