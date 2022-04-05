package com.sist.temp;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        RecipeDAO dao=new RecipeDAO();
        long start=System.currentTimeMillis();
        dao.recipeListData_oracle1(12000);
        long end=System.currentTimeMillis();
        System.out.println("걸린 시간:"+(end-start));
	}

}
