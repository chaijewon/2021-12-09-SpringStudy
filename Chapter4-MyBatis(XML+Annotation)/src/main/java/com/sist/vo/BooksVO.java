package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
// jar�� ���� ==> jar�� �ִ� ��ġ�� �̵� 
// java -jar ����.jar 
// �ǹ� => ���� lombok�� ����Ѵ� 
@Getter // ���α׷� ������ ��� 
@Setter	// MyBatis�� ���
public class BooksVO {
    private String title;
    private String price;
	
}
