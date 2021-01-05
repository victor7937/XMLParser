package by.victor.jwd.main;

import by.victor.jwd.dao.utils.parser.impl.XMLParserImpl;
import by.victor.jwd.service.ServiceFactory;
import by.victor.jwd.service.XMLParseService;
import by.victor.jwd.tree.XMLTree;

public class Main {

    public static void main(String[] args) {

        ServiceFactory factory = ServiceFactory.getInstance();
        XMLParseService service = factory.getXmlParseService();

        String treeView = service.getXMLTreeView();
        System.out.println(treeView);

    }

}
