package com.zhoufb.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.suneee.iesp.declaration" })
public class MybatisScanConfig {
	
	@Bean
	@Autowired
	public MapperScannerConfigurer mapperScannerConfigurer(SqlSessionFactory sqlSessionFactory){
		MapperScannerConfigurer mapperScannerConfigurer=new org.mybatis.spring.mapper.MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.zhoufb.dao");
		mapperScannerConfigurer.setSqlSessionFactory(sqlSessionFactory);
		return mapperScannerConfigurer;
	}
}
