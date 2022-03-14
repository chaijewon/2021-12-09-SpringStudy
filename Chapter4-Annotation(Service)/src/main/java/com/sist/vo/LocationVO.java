package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

// ����� ���� �������� (���������� �޸� �Ҵ����� �ʴ´�)
// ~VO , ~DTO => ����� ���� �������� (�޸��Ҵ� �ʿ�ø��� ���α׷��Ӱ� ���)
// Integer , Double , String (�����͸� ��Ƽ� �����ϴ� ����) => �Ѱ�,�Ѹ� 
@Setter
@Getter
public class LocationVO {
  private String title;
  private String address;
  private String msg;
}
