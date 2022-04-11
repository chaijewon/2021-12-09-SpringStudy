package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// My-SQL연동 => 입출력 (JSP로 값을 전송 할 수 없다) => Controller
@Repository
public class StudentDAO {
   @Autowired
   private StudentMapper mapper;
   
   public List<StudentVO> stdListData(Map map)
   {
	   return mapper.stdListData(map);
   }
   public int studentTotalPage()
   {
	   return mapper.studentTotalPage();
   }
   public void stdInsert(StudentVO vo)
   {
	   mapper.stdInsert(vo);
   }
   public void stdDelete(int hakbun)
   {
	   mapper.stdDelete(hakbun);
   }
   public StudentVO stdUpdateData(int hakbun)
   {
	   return mapper.stdUpdateData(hakbun);
   }
   public void stdUpdate(StudentVO vo)
   {
	   mapper.stdUpdate(vo);
   }
}
