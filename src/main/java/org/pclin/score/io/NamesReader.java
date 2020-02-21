package org.pclin.score.io;

import java.io.IOException;
import java.util.List;

public interface NamesReader {
    List<String> readNames(String datasource) throws IOException;
}
