package by.victor.jwd.dao.impl;

import by.victor.jwd.dao.XMLDAO;
import by.victor.jwd.dao.utils.XmlFileReader;
import by.victor.jwd.parser.ParserFactory;
import by.victor.jwd.parser.XMLParser;
import by.victor.jwd.tree.XMLTree;

import java.io.IOException;
import java.net.URISyntaxException;

public class XMLDAOImpl implements XMLDAO {

    private static final String FILENAME = "sample.xml";

    @Override
    public XMLTree getXMLTree() {
        ParserFactory factory = ParserFactory.getInstance();
        XMLParser xmlParser = factory.getXMLParser();
        String xmlStringForm;
        try {
            xmlStringForm = XmlFileReader.getXMLFileStringForm(FILENAME);
        } catch (IOException | URISyntaxException e) {
            return null;
        }

        return xmlParser.constructTree(xmlStringForm);
    }
}
