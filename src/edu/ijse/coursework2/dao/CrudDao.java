/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.dao;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface CrudDao<T, ID> extends SuperDao {

    // Save an entity to the database
    public boolean save(T t) throws Exception;

    // Update an existing entity in the database
    public boolean update(T t) throws Exception;

    // Delete an entity from the database
    public boolean delete(ID id) throws Exception;

    // Search for an entity by its ID
    public T search(ID id) throws Exception;

    // Get all entities from the database
    public ArrayList<T> getAll() throws Exception;
}