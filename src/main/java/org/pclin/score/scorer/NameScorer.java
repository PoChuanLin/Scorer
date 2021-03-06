package org.pclin.score.scorer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
@Log4j2
@RequiredArgsConstructor
public class NameScorer implements Scorer {
    // Map of value for each character
    private final CharValue charValue;

    /**
     *  Calculate the score for individual name
     */
    @Override
    public int score(String name) {
        log.traceEntry("name: {}", name);
        checkArgument(isNotBlank(name), "name is blank");

        // sum up the value for each char in name
        int score = 0;
        for (char c : name.toCharArray()) {
            Integer val = charValue.get(c);
            score = (val != null)? (score + val) : score;
        }

        log.debug("name/score : {}/{}", name, score);
        return score;
    }
}
