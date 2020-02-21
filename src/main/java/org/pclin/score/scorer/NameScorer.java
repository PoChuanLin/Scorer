package org.pclin.score.scorer;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
@Log4j2
public class NameScorer implements Scorer {
    // Map of value for each character
    private final CharValue charValue;

    public NameScorer(CharValue charValue) {
        this.charValue = charValue;
    }

    /**
     *  Calculate the score for individual name
     * @param name
     * @param weight
     * @return
     */
    @Override
    public int score(String name, int weight) {
        log.traceEntry("name/weight: {}/{}", name, weight);
        checkArgument(isNotBlank(name), "name is blank");

        // sum up the value for each char in name
        int score = 0;
        for (char c : name.toCharArray()) {
            Integer val = charValue.get(c);
            score = (val != null)? (score + val) : score;
        }
        // multiple value of name by weight
        score *= weight;

        log.debug("name/weight/score : {}/{}/{}", name, weight, score);
        return score;
    }
}
