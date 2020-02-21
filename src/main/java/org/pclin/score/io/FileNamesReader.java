package org.pclin.score.io;

import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FileNamesReader implements NamesReader {

    @Override
    public List<String> readNames(String filename) throws IOException {
        log.traceEntry("filename: {}", filename);
        checkArgument(isNotBlank(filename), "filename is blank");

        @Cleanup
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        // read data from file, parse each line as a record
        CSVParser parser = new CSVParser(reader, CSVFormat.RFC4180);
        List<CSVRecord> records = parser.getRecords();

        List<String> names = new ArrayList<>();
        // adding items in lines to name list
        records.stream().map(CSVRecord::iterator).forEach(itr -> itr.forEachRemaining(names::add));
        names.removeIf (StringUtils::isBlank);

        log.traceExit("names size: {}", names.size());
        return names;
    }
}
