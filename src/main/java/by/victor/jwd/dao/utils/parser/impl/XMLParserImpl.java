package by.victor.jwd.dao.utils.parser.impl;

import by.victor.jwd.dao.utils.parser.XMLParser;
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

/* XMLTree xmlTree = new XMLTree();

        int rootStart = xmlStringForm.indexOf('<');
        int rootEnd = xmlStringForm.indexOf('>');

        String rootData = xmlStringForm.substring(rootStart+1, rootEnd);
        String closingRootNode = "</" + rootData + ">";

        int closingRootIndex = xmlStringForm.lastIndexOf(closingRootNode);
        //if (closingRootIndex == -1) {
           // throw new InputMismatchException("XML not well formed");
        //}

        XMLTree.Node rootNode = new XMLTree.Node(rootData);
        xmlTree.setRoot(rootNode);

        processXMLString(rootNode, xmlStringForm.substring(rootEnd+1, closingRootIndex));

        return xmlTree;*/

 /*int nodeStart = stringForModify.indexOf('<');
        int nodeEnd = stringForModify.indexOf('>');

        if (nodeStart == -1 && nodeEnd == -1) {
            parent.addChild(new XMLTree.Node(stringForModify));
        } else {
            String childNodeData = stringForModify.substring(nodeStart+1, nodeEnd);
            String closingChildNode = "</" + childNodeData + ">";
            int closingChildIndex = stringForModify.indexOf(closingChildNode);

            /*if (!stringForModify.substring(nodeEnd+1).contains(closingChildNode)) {
                throw new InputMismatchException("XML not well formed");

            } else {*/
              /*  XMLTree.Node childNode = new XMLTree.Node(childNodeData);

                parent.addChild(childNode);
                processXMLString(childNode, stringForModify.substring(nodeEnd+1, closingChildIndex));

                int siblingStart = closingChildIndex + closingChildNode.length();
                processXMLString(parent, stringForModify.substring(siblingStart));*/
//}
//}