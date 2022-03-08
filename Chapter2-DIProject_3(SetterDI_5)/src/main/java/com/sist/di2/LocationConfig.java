package com.sist.di2;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// VO => Config.xml에 등록 => Mapper => DAO
// SpringConfig제작 => MainClass에 호출 
@Configuration
// 자동 메모리 할당 (스프링 설정 파일)
// DI => 일반 변수 / 객체 주소 설정 
//       p:name   p:name-ref
public class LocationConfig {
    // Mybatis에 오라클 정보 => DataSource => 확장 (BasicDataSource)
	@Bean("ds")
	public BasicDataSource dataSource()
	{
		//1. 메모리 할당 
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@211.63.89.131:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// MyBatis로 전송 => getConnection(),disConnection()
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		// 1. DataSource 
		ssf.setDataSource(dataSource());
		// 2. XML p:dataSource-ref
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}
	@Bean("dao")
	public LocationDAO locDao() throws Exception
	{
		LocationDAO dao=new LocationDAO();
		dao.setSqlSessionFactory(sqlSessionFactory());
		// p:sqlSessionFactory-ref
		return dao;
	}
  
}








