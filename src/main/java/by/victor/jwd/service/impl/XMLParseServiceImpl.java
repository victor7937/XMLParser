package by.victor.jwd.service.impl;

import by.victor.jwd.dao.DAOFactory;
import by.victor.jwd.dao.XMLDAO;
import by.victor.jwd.service.XMLParseService;
import by.victor.jwd.tree.XMLTree;

public final class XMLParseServiceImpl implements XMLParseService {

    @Override
    public String getXMLTreeView() {
        DAOFactory factory = DAOFactory.getInstance();
        XMLDAO dao = factory.getXMLDAO();
        XMLTree tree = dao.getXMLTree();

        return tree.getTreeStructureString();
    }
}