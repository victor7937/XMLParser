package by.victor.jwd.parser;

import by.victor.jwd.parser.impl.XMLParserImpl;

public final class ParserFactory {

    private static final ParserFactory instance = new ParserFactory();

    private final XMLParser xmlParser = new XMLParserImpl();

    private ParserFactory() {}

    public XMLParser getXMLParser() { return xmlParser; }

    public static ParserFactory getInstance() { return instance; }
}
