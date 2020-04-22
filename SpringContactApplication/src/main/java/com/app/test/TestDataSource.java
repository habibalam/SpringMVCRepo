package com.app.test;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		
		DataSource ds=ctx.getBean(DataSource.class);
		JdbcTemplate jt=new JdbcTemplate(ds);
		String sql ="INSERT INTO user(name,phone,email,address,loginName,password) VALUES (?,?,?,?,?,?)";
	    Object[] param = new Object[]{"raja","12345","abc@gmail.com","patna","v3","55884"};
	    jt.update(sql,param);
	    System.out.println("--------Sql executed------");
	    System.out.println(jt);
	}

	
	
	
}
