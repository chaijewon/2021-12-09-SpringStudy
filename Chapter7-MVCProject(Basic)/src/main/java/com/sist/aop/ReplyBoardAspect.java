package com.sist.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 공통모듈 
@Aspect // 메모리 할당이 안된다 (알림 => 프로그램에서 공통으로 사용된 기능을 가지고 있다)
@Component
public class ReplyBoardAspect {

}
