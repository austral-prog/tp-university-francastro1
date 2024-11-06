package com.university.Creator;

import com.university.University;

import java.util.List;

public interface EntityCreator <T>{
    T getOrCreate(String parts, List<T> entities, University university);
}
