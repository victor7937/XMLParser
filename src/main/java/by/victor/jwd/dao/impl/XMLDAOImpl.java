package by.victor.jwd.dao.impl;

import by.victor.jwd.dao.XMLDAO;
import by.victor.jwd.dao.utils.XmlFileReader;
import by.victor.jwd.parser.ParserFactory;
import by.victor.jwd.parser.XMLParser;
import by.victor.jwd.tree.XMLTree;


public final class XMLDAOImpl implements XMLDAO {

    private static final String FILENAME = "sample.xml";

    @Override
    public XMLTree loadXMLTree() {
        ParserFactory factory = ParserFactory.getInstance();
        XMLParser xmlParser = factory.getXMLParser();
        String xmlStringForm = XmlFileReader.loadXMLFileStringForm(FILENAME);
        return xmlStringForm.isEmpty() ? null : xmlParser.constructTree(xmlStringForm);
    }
}
