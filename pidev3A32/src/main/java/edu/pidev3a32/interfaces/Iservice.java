package edu.pidev3a32.interfaces;

import edu.pidev3a32.entities.Service;

import java.util.List;

public interface Iservice<T> {

    public void addEntity(T t);
    public void seletectEntity(T t);
    public void updateEntity(T t);
    public List<T> getAllData();






}
