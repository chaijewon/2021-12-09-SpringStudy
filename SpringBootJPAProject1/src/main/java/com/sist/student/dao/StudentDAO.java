package com.sist.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.student.entity.StudentEntity;

@Repository
public interface StudentDAO extends JpaRepository<StudentEntity, Integer>{
  // Where findByXxx() findByNameLike(String name) 
  // where name=       findByNameAndHakbun   name=? and hakbun=?
  public StudentEntity findByHakbun(int hakbun);
}
