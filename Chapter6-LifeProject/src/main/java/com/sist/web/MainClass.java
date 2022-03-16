package com.sist.web;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    // 스프링 : 객체 관리자 (생명주기 = 생성 ~ 소멸) => 컨테이너 
	// 화요일 : 3.22 => 이력서 소개  ==> 1주 (이력서) => 제출 (추천)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenericXmlApplicationContext app=
        		new GenericXmlApplicationContext("app.xml");
        Sawon sa=app.getBean("sa",Sawon.class);
        sa.print();
        app.close();
        // 1. 모든 클래스 메모리 할당
        // 2. setter를 이용해서 값 주입 
        // 3. 저장하는 단계 (Map) 
        // 4. 프로그래머가 활용 
        // 5. 사용후에 메모리 해제 
        /*
         *  Sawon() Call..:객체 생성후 Map에 저장
			setName() Call...:name변수에 값을 첨부...
			setSex() Call...:sex변수에 값을 첨부...
			객체 ID읽기...
			생성된 객체 저장하는 단계...
			setter를 이용한 값 주입 완료... 스프링에서 자동 처리
			--------------------------------------
			프로그래머가 호출...
			=== 사원 정보 ===
			이름:홍길동
			성별:남자
			---------------------------------------
			destroy() Call...:객체 소멸시 호출되는 메소드
			                         스프링에서 자동 처리 

         */
	}

}
