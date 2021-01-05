package by.victor.jwd.dao.impl;

import by.victor.jwd.dao.XMLDAO;
import by.victor.jwd.dao.utils.XmlFileReader;
import by.victor.jwd.dao.utils.parser.ParserFactory;
import by.victor.jwd.dao.utils.parser.XMLParser;
import by.victor.jwd.tree.XMLTree;

import java.io.IOException;
import java.net.URISyntaxException;

public class XMLDAOImpl implements XMLDAO {

    @Override
    public XMLTree getXMLTree() {
        ParserFactory factory = ParserFactory.getInstance();
        XMLParser xmlParser = factory.getXMLParser();
        String xmlStringForm;
        try {
            xmlStringForm = XmlFileReader.getXMLFileStringForm("sample.xml");
        } catch (IOException | URISyntaxException e) {
            return null;
        }

        return xmlParser.constructTree(xmlStringForm);
    }
}
