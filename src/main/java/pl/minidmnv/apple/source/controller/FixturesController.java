package pl.minidmnv.apple.source.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.minidmnv.apple.data.Fixture;
import pl.minidmnv.apple.source.repository.FixtureRepository;

/**
 * @author minidmnv
 */
@RestController
@RequestMapping("/fixtures")
public class FixturesController {

    private static final Integer MAX_LIMIT = 25;

    private FixtureRepository fixtureRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/limit/{limit}")
    List<Fixture> getUpcomingFixtures(@PathVariable Integer limit) {
        setMaxLimit(limit);

        return getUpcomingFixtures(limit);
    }

    private void setMaxLimit(@PathVariable Integer limit) {
        if (limit > MAX_LIMIT) {
            limit = MAX_LIMIT;
        }
    }
}
