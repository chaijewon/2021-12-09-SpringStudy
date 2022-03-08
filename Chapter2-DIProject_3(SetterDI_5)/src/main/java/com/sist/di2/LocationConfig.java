package com.sist.di2;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// VO => Config.xml�� ��� => Mapper => DAO
// SpringConfig���� => MainClass�� ȣ�� 
@Configuration
// �ڵ� �޸� �Ҵ� (������ ���� ����)
// DI => �Ϲ� ���� / ��ü �ּ� ���� 
//       p:name   p:name-ref
public class LocationConfig {
    // Mybatis�� ����Ŭ ���� => DataSource => Ȯ�� (BasicDataSource)
	@Bean("ds")
	public BasicDataSource dataSource()
	{
		//1. �޸� �Ҵ� 
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@211.63.89.131:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// MyBatis�� ���� => getConnection(),disConnection()
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








