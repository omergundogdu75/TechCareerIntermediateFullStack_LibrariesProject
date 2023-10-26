package org.omergundogdu.dao;


import org.omergundogdu.database.DatabaseConnection;
import org.omergundogdu.dto.RegisterDto;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDaoGenerics <T> {

    public String speedData(Long id);
    public String allDelete();
    ////////////////////////////////////////

    // C R U D
    // CREATE
    public void create(T t);

    // FIND BY ID
    public T findById(Long id);

    // LIST
    public ArrayList<T> list();

    // UPDATE
    public T update(Long id,T t);

    // DELETE
    public T delete(RegisterDto registerDto );

    ////////////////////////////////////////
    // interface Gövdeli yapmak istiyorsak; default yazacağız.
    default Connection getInterfaceConnection(){ //java.sql.Connection
        return DatabaseConnection.getInstance().getConnection();
    }
} //end interface