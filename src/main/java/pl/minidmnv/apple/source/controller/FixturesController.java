package pl.minidmnv.apple.source.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.minidmnv.apple.data.Fixture;

import java.util.List;

/**
 * @author minidmnv
 */
@RestController
@RequestMapping("/fixtures")
public class FixturesController {

    private static final Integer MAX_LIMIT = 25;

    @RequestMapping(method = RequestMethod.GET, value = "/limit/{limit}")
    List<Fixture> getUpcomingFixtures(@PathVariable Integer limit) {
        setMaxLimit(limit);

        return null;
    }

    private void setMaxLimit(@PathVariable Integer limit) {
        if (limit > MAX_LIMIT) {
            limit = MAX_LIMIT;
        }
    }
}
