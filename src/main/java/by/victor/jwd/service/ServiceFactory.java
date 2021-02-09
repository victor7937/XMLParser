package by.victor.jwd.service;

import by.victor.jwd.service.impl.XMLParseServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final XMLParseService xmlParseService = new XMLParseServiceImpl();

    private ServiceFactory() {}

    public XMLParseService getXmlParseService() { return xmlParseService; }

    public static ServiceFactory getInstance() { return instance; }
}
