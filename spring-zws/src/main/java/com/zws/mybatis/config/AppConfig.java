package com.zws.mybatis.config;

import com.zws.mybatis.imports.MyImportBeanDefinitionRegistrar;
import com.zws.mybatis.imports.MyMapperScan;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author zhengws
 * @date 2020-01-29 22:33
 */
@Configuration
@ComponentScan(value = {"com.zws.mybatis"})
@MapperScan(value = {"com.zws.mybatis.mapper"})
//@MyMapperScan
public class AppConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/paper?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
