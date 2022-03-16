package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//<component-scan base-package=""/>
@ComponentScan(basePackages = {"com.sist.*"})
@EnableWebMvc 
// web에서 동작이 가능하게 활성화 
public class HotelConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		 configurer.enable();
		 // HandlerMapping , HandlerAdapter 클래스 메모리 할당 
	}
   
	
	/*
    *  <bean id="viewResolver"
          class="org.springframework.web.servlet.view.InternalResourceViewResolver"
          p:prefix="/"
          p:suffix=".jsp" 
     />
    
   */
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver r=
				new InternalResourceViewResolver();
		r.setPrefix("/");
		r.setSuffix(".jsp");
		return r;
	}
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
     p:driverClassName="#{db['driver']}"
     p:url="#{db['url']}"
     p:username="#{db['username']}"
     p:password="#{db['password']}"
     p:maxActive="#{db['maxActive']}"
     p:maxIdle="#{db['maxIdle']}"
     p:maxWait="#{db['maxWait']}"
   />
	 */
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=
				new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@211.63.89.131:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(20);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		
		return ds;
	}
	/* <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="dataSource"
    />
	 * 
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	
	@Bean("mapper")
	public MapperFactoryBean mapperFactoryBean() throws Exception
	{
		MapperFactoryBean mfb=new MapperFactoryBean();
		mfb.setSqlSessionFactory(sqlSessionFactory());
		mfb.setMapperInterface(com.sist.mapper.HotelMapper.class);
		return mfb;
	}
}





