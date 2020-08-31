package by.epamtc.textprocessing.server.dao;

import by.epamtc.textprocessing.server.dao.impl.TextDAOImpl;

public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
    private static final TextDAO TEXT_DAO = new TextDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public TextDAO getTextDAO() {
        return TEXT_DAO;
    }
}
