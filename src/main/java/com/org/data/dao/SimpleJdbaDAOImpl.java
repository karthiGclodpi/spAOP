package com.org.data.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbaDAOImpl extends SimpleJdbcDaoSupport {
	
	
	public int getCircleCount(){
		String sql="select count(*) from circle";
		
		return this.getJdbcTemplate().queryForInt(sql);
	}

	
}
