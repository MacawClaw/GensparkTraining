package com.genspark.StudentDB.Dao;

import com.genspark.StudentDB.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
}
