package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  PRODUCT_ID     NOT NULL NUMBER        
PRODUCT_PRICE  NOT NULL NUMBER        
PRODUCT_NAME   NOT NULL VARCHAR2(500) 
PRODUCT_POSTER NOT NULL VARCHAR2(260)
 */
@Getter
@Setter
public class GoodsVO {
  private int id,price;
  private String name,poster;
}
