package com.yegor.dao;

import com.yegor.entities.StudentEntity;

import java.util.List;

/**
 * Created by YegorKost on 11.03.2017.
 */
public interface StudentDAO {
    void add(StudentEntity studentEntity);
    StudentEntity get(int id);
    List<StudentEntity> getAll();
    void update(StudentEntity studentEntity);
    void delete(StudentEntity studentEntity);
}
