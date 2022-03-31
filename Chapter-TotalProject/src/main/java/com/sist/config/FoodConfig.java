package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/*
 *   <!-- AOP 설정 
           자바 : @EnableAspectAutoProxy
    -->
    <aop:aspectj-autoproxy/> <!-- Annotation으로 작업시에  -->
    <context:component-scan base-package="com.sist.*"/>
    <!-- 사용자 정의 메모리 할당 
          @Component, 
          @Repository, 
          @Service, 
          @Controller, 
          @RestController, 
          @ControllerAdvice, 
          @Configuration
    -->
    <!-- ViewResolver -->
    <!-- 
         p: property : setXxx() => 값을 채워준다 
         c: constructor() 
         = setter DI , constructor DI
         DI (****** 100%) 
         === 의존성 주입 
             ===== 객체와 객체의 관계 (스프링에서 객체 관리) => 연결 (조립)
             
             1. 포트폴리어 (2개 , 개인) => 이력서 (****) 
             2. 면접 
             3. 실무 적응 (Order) 
     -->
    
    <bean id="viewResolver"
         class="org.springframework.web.servlet.view.InternalResourceViewResolver"
         p:prefix="/"
         p:suffix=".jsp"
    />
     * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
        p:driverClassName="#{db['driver']}"
        p:url="#{db['url']}"
        p:username="#{db['username']}"
        p:password="#{db['password']}"
    />
    <!-- Transaction -->
    <tx:annotation-driven/>
    <!--  @Transactional  -->
    <bean id="transactionManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
        p:dataSource-ref="ds"
    />
    <!-- 
         DQL(SELECT)
         DML(INSERT, UPDATE ,DELETE) => 저장 (COMMIT), 취소(ROLLBACK)
         = 일괄처리 
                  트랜잭션 설정 => 한개의 기능 수행 DML이 여러개 일 경우  
                  동시에 처리 
                   = 입고/재고
                   = 출고/재고 
                   = 카드결제/포인트설정 
                   COMMIT => 정상수행시에 오라클 저장 
         try
         {
            getConnection(); 
            ============================
            @Around() conn.setAutoCommit(false); = 자바 JDBC는 autoCommit()
            ============================
                        입고 INSERT
                        재고 Update
            ====================
            @Around() conn.commit()       
            ====================     
         }catch(Exception ex)
         {
            ==================
            conn.rollback() @AfterThrowing
            ==================
         }
         finally
         {
           ===========================
            conn.setAutoCommit(true) @After
           ===========================
            disConnection()
         }
     -->
    <!-- MyBatis 실행 과정  -->
    <!-- MyBatis 연결 (getConnection,disConnection) -->
    <bean id="ssf"
       class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="dataSource"
    />
    <mybatis-spring:scan base-package="com.sist.mapper"/>
    <!-- 
            자바 
      @MapperScan(base-package={"com.sist.mapper"})
     -->
 */
@Configuration  // 4문제 xml과 자바의 차이점 (보안)
/*
 *  aop:aspectj-autoproxy/> <!-- Annotation으로 작업시에  -->
    <context:component-scan base-package="com.sist.*"/>
    <tx:annotation-driven/>
    <!--  @Transactional  -->
    <bean id="transactionManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
        p:dataSource-ref="ds"
    />
     * <mybatis-spring:scan base-package="com.sist.mapper"/>
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.sist.*"})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.sist.mapper"})
public class FoodConfig {
  // ViewResolver 처리
  /*
   *   <bean id="viewResolver"
         class="org.springframework.web.servlet.view.InternalResourceViewResolver"
         p:prefix="/"
         p:suffix=".jsp"
    />
   */
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver vr=
				new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
  // BasicDataSource
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
        p:driverClassName="#{db['driver']}"
        p:url="#{db['url']}"
        p:username="#{db['username']}"
        p:password="#{db['password']}"
    />
	 */
	@Bean("ds")
	// DataSource (interface) => 구현된 클래스 (BasicDataSource)
	// public class BasicDataSource implements DataSource
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		// 데이터베이스 정보를 변수로 가지고 있다 => setXxx()에 값을 채워준다 
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver"); // p:driverClassName=""
		ds.setUrl("jdbc:oracle:thin:@211.63.89.131:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
  // SqlSessionFactoryBean 
	/*
	 * <bean id="ssf"
       class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="dataSource"
    />
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());//p:dataSource-ref
		return ssf.getObject();
	}
  // Transaction처리 
	/*
	 * <bean id="transactionManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
        p:dataSource-ref="ds"
    />
	 */
	@Bean("transactionManager")
	public DataSourceTransactionManager txManager()
	{
		DataSourceTransactionManager tx=
				new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
}






