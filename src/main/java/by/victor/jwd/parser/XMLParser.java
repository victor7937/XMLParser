package by.victor.jwd.parser;

import by.victor.jwd.tree.XMLTree;

public interface XMLParser {
    XMLTree constructTree(String xmlString);
}
