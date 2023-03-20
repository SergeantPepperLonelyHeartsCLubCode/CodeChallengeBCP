package de.bcxp.challenge.input;

import java.io.IOException;
import java.util.List;

public interface InputFileReaderInterface {
    public List<String> readFile(String fileName) throws IOException;
}
