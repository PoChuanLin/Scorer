package org.pclin.score;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pclin.score.io.NamesReader;
import org.pclin.score.scorer.Scorer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;

@Service
@Log4j2
@RequiredArgsConstructor
public class ScoreRunner implements ApplicationRunner {
    private final NamesReader reader;
    private final Scorer scorer;

    @Override
    public void	run(ApplicationArguments args) throws Exception {
        log.traceEntry("args: {}", args);

        // Command line parameter
        List<String> arguments = args.getNonOptionArgs();
        checkArgument ((arguments.size() > 0), "command line parameter (dataSource) is empty.");

        String dataSource = arguments.get(0);
        log.info("dataSource: {}", dataSource);

        // Read from data file
        List<String> names = reader.readNames(dataSource);
        log.info("{} names read from {}", names.size(), dataSource);

        // Calculate score
        long total = calculate(names);
        log.info("Total score: {}", total);

        log.traceExit();
    }

    /**
     *  Calculate total score for the name list
     */
    long calculate(List<String> names) {
        names.sort(null);  // sort by natural ordering
        int order = 1;
        long total = 0;
        for (String name : names) {
            total += scorer.score(name, order++);
        }
        return total;
    }
}
