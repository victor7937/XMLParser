package by.victor.jwd.dao.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class XmlFileReader {

    public static String getXMLFileStringForm (String fileName) throws IOException, URISyntaxException {
        StringBuilder xmlStringForm = new StringBuilder();
        try(Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))){
            lines.forEach(xmlStringForm::append);
        }
        return xmlStringForm.toString();
    }

}
