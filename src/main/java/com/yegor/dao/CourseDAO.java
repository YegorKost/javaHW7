package com.yegor.dao;

import com.yegor.entities.CourseEntity;

import java.util.List;

/**
 * Created by YegorKost on 11.03.2017.
 */
public interface CourseDAO {
    void add(CourseEntity courseEntity);
    CourseEntity get(int id);
    List<CourseEntity> getAll();
    void update(CourseEntity courseEntity);
    void delete(CourseEntity courseEntity);
}
