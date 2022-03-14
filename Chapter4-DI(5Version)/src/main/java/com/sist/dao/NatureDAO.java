package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.NatureMapper;
import com.sist.vo.NatureVO;
// Mapper => DAO => MainClass
/*
 *   ���������� ��Ű�� ������ Ŭ���� ��� 
 *   => �޸� �Ҵ� ��û
 *   Ŭ�������� ������̼��� �÷��� ���� 
 *   1) Component  : �Ϲ� Ŭ���� (�� ũ�Ѹ� , XML�Ľ� , ������ �м�)
 *                   �����ͺм� : AI , data.go.kr (������ ����)
 *   2) Repository : ����� (DAO=�����ͺ��̽� ����)
 *   3) Service : BI(DAO�������� �����ؼ� ���)
 *   ------------------------------------- ������ ���
 *   4) Controller : Model (��û�� �޾Ƽ� ��ûó�� �Ŀ� ������� ����) 
 *                   => ȭ���̵� (���ϸ��� ����)
 *   5) RestController : Model (��û�� �޾Ƽ� ��ûó�� �Ŀ� ������� ����) 
 *                   => ������ ���� (Ajax , VueJS , ReactJS) => JSON
 *   6) ControllerAdvice : ���� ����ó�� 
 *   -------------------------------------
 *   --------------------
 *   => �޸� �Ҵ��� ���� ��
 */
@Repository
public class NatureDAO {
   @Autowired
   private NatureMapper mapper;// �ڵ����� MyBatis���� ������ �ȴ� 
   
   public List<NatureVO> natureListData()
   {
	   return mapper.natureListData();
   }
}
