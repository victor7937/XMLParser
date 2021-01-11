package by.victor.jwd.parser.impl;

import by.victor.jwd.parser.XMLParser;
import by.victor.jwd.tree.XMLTree;

public class XMLParserImpl implements XMLParser {

    public XMLParserImpl() { }

    private void processXMLString(XMLTree.Node parent, String stringForModify) {

        NodeParser nodeParser = NodeParser.parse(stringForModify);
        if (nodeParser.isFinal()) {
            if (nodeParser.isContent())
                parent.setContent(nodeParser.getContent());
        }
        else {
            XMLTree.Node childNode = new XMLTree.Node(nodeParser.getNodeData());
            childNode.setAttributes(nodeParser.getAttributes());
            parent.addChild(childNode);
            processXMLString(childNode, nodeParser.getChildrenSubstring());
            processXMLString(parent, nodeParser.getSiblingSubstring());
        }
    }

    @Override
    public XMLTree constructTree(String xmlStringForm)  {

        XMLTree xmlTree = new XMLTree();
        NodeParser nodeParser = NodeParser.parse(xmlStringForm);
        String rootData = nodeParser.getNodeData();

        XMLTree.Node rootNode = new XMLTree.Node(rootData);
        xmlTree.setRoot(rootNode);
        processXMLString(rootNode, nodeParser.getChildrenSubstring());

        return xmlTree;
    }

}
