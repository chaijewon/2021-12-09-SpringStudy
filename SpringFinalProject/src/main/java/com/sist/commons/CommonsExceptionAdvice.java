package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;

// Controller에서 발생하는 모든 예외처리를 공통으로 사용 
@ControllerAdvice  // 메모리할당이 가능 
// 스프링에서 관리 : ~Controller , ~DAO , ~Advice , ~Aspect , ~Manager(open api)
// 프로그래머 관리 : ~VO , ~DTO(일반 데이터형 취급) , interface(Mapper)
public class CommonsExceptionAdvice {

}
