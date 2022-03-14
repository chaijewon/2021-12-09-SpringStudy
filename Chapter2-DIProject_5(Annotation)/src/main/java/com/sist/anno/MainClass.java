package com.sist.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
	@Autowired
    private HotelDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
