package by.victor.jwd.dao.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class XmlFileReader {

    public static String loadXMLFileStringForm(String fileName) {
        boolean fileErrFlag = false;
        StringBuilder xmlStringForm = new StringBuilder();
        Stream<String> lines = null;
        try {
            URL url = ClassLoader.getSystemResource(fileName);
            if (url != null) {
                lines = Files.lines(Paths.get(url.toURI()));
                lines.forEach(xmlStringForm::append);
            }
        } catch ( URISyntaxException | IOException e) {
            fileErrFlag = true;
        } finally {
            if (lines != null) {
                lines.close();
            }
        }
        return fileErrFlag ? "" : xmlStringForm.toString();
    }
}
