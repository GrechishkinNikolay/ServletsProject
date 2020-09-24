package ru.rsreu.Grechishkin.db.dao;

import ru.rsreu.Grechishkin.db.dao.oracle.OracleDAOFactory;

public enum DBType {
    XML {
        @Override
        public AbstractDAOFactory getDAOFactory() {
            return null;
        }

        @Override
        public String toString() {
            return "XML";
        }
    },
    ORACLE {
        @Override
        public AbstractDAOFactory getDAOFactory() {
            return new OracleDAOFactory();
        }

        @Override
        public String toString() {
            return "Oracle";
        }
    };

    public abstract AbstractDAOFactory getDAOFactory();
}
