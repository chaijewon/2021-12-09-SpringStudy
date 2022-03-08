package com.sist.di;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/*
 *  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
      p:driverClassName="oracle.jdbc.driver.OracleDriver"
      p:url="jdbc:oracle:thin:@211.63.89.131:1521:XE"
      p:username="hr"
      p:password="happy"
    />
    <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
      p:configLocation="classpath:Config.xml"
    />
    <!-- MyBatis생성  -->
    <bean id="dao" class="com.sist.di.EmpDAO"
      p:sqlSessionFactory-ref="ssf"
    />
 */
// app.xml을 대신 => XML대신 자바로 설정(5)
@Configuration
//85page
public class EmpConfig {
  @Bean("ds")
  public BasicDataSource basicDataSource()
  {
	  /*
	   *   84page
	   *  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		      p:driverClassName="oracle.jdbc.driver.OracleDriver"
		      p:url="jdbc:oracle:thin:@211.63.89.131:1521:XE"
		      p:username="hr"
		      p:password="happy"
		    />
	   */
	  BasicDataSource ds=new BasicDataSource();
	  ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	  ds.setUrl("jdbc:oracle:thin:@211.63.89.131:1521:XE");
	  ds.setUsername("hr");
	  ds.setPassword("happy");
	  return ds;
  }
  @Bean("ssf")
  public SqlSessionFactory sqlSessionFactory() throws Exception
  {
	  /*
	   * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		      p:dataSource-ref="ds"
		      p:configLocation="classpath:Config.xml"
		    />
	   */
	  SqlSessionFactoryBean ssf=
			  new SqlSessionFactoryBean();
	  ssf.setDataSource(basicDataSource());
	  Resource res=new ClassPathResource("Config.xml");
	  ssf.setConfigLocation(res);
	  return ssf.getObject();
  }
  @Bean("dao")
  public EmpDAO empDao() throws Exception
  {
	  /*
	   *  <bean id="dao" class="com.sist.di.EmpDAO"
		      p:sqlSessionFactory-ref="ssf"
		    />
	   */
	  EmpDAO dao=new EmpDAO();
	  dao.setSqlSessionFactory(sqlSessionFactory());
	  return dao;
  }
  
}






