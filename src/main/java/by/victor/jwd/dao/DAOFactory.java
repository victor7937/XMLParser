package by.victor.jwd.dao;

import by.victor.jwd.dao.impl.XMLDAOImpl;
import by.victor.jwd.tree.XMLTree;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final XMLDAO xmldao = new XMLDAOImpl() {};

    private DAOFactory() {}

    public XMLDAO getXMLDAO() {
        return xmldao;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
