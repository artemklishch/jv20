package basesyntax.service.impl;

import basesyntax.exceptions.CustomRuntimeException;
import basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        if (filePath == null) {
            throw new CustomRuntimeException("The file path is equal to null");
        }
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read data. Error occurred: " + e);
        }
    }
}