package com.yegor.dao;

import java.util.List;

/**
 * Created by YegorKost on 08.03.2017.
 */
public interface DAO<E> {
    void add(E e);
    E get(int id);
    List<E> getAll();
    void update(E e);
    void delete(E e);
}
