package com.sist.chat;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.*;
public class WebSocketChatHandler extends TextWebSocketHandler{
    // 클라이언트 정보 저장 
	private Map<String,WebSocketSession> users=
			  new HashMap<String ,WebSocketSession>();
	// 클라이언트가 접속시에 처리 => 클라이언트 정보 저장 
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	     System.out.println(session.getId()+"님이 입장하셨습니다");
	     users.put(session.getId(), session);//session=IP,PORT
	}
    // 클라이언트의 채팅 메세지 전송 
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession ws:users.values())
		{
			ws.sendMessage(message);
		}
	}
    // 클라이언트 퇴장 => 저장된 클라이언트 정보 삭제 
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId()+"님이 퇴장하셨습니다");
		users.remove(session.getId());
	}
    
}
