package by.victor.jwd.dao.utils.parser;

import by.victor.jwd.dao.utils.parser.impl.XMLParserImpl;
import by.victor.jwd.service.ServiceFactory;
import by.victor.jwd.service.XMLParseService;
import by.victor.jwd.service.impl.XMLParseServiceImpl;

public class ParserFactory {

    private static final ParserFactory instance = new ParserFactory() {};

    private final XMLParser xmlParser = new XMLParserImpl();

    private ParserFactory() {}

    public XMLParser getXMLParser() {
        return xmlParser;
    }

    public static ParserFactory getInstance() {
        return instance;
    }
}
