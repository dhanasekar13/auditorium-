package com.ds;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class singldata {
    private static final PersistenceManagerFactory oneobj =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private singldata() {}

    public static PersistenceManagerFactory get() {
        return oneobj;
    }
}



