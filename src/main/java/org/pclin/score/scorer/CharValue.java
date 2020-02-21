package org.pclin.score.scorer;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *   loading (character -> value) map from properties file, with entry prefix "char"
 */
@ConfigurationProperties(prefix = "char")
@Configuration
public class CharValue extends HashMap<Character, Integer> {
}
