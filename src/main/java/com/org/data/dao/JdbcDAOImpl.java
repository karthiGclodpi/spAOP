package com.org.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
 









import com.org.data.model.Circle;


@Component
public class JdbcDAOImpl {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedPjdbcTemplate;
/*	public Circle getCircle(int circleID){
			Connection conn= null;
			Circle circle=null;
			
			try {
				
				conn=dataSource.getConnection();
				PreparedStatement ps= conn.prepareStatement("Select * from circle where id= ?");
				ps.setInt(1, circleID);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					circle = new Circle(rs.getInt("id"), rs.getString("name"));
				}
				rs.close();
				conn.close();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		 	finally
			{
		 		if(conn!=null)
		 		{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		}
			}
			return circle;
		}*/
	
	public int getCircleCount(){
		String sql="select count(*) from circle";
		
		return jdbcTemplate.queryForInt(sql);
	}
	
	
	public String getCircleNema(int circleID)
	{
		String sql="Select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleID}, String.class);
	}
	
	public Circle getCircleforID(int circleID)
	{
		String sql="Select * from circle where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleID}, new CircleMapper());
	}
	
	public List<Circle> getAllcircle()
	{
		String sql="Select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle)
	{
		String sql="insert into circle (id,name)value(?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	
	public void insertCircleNamedP(Circle circle)
	{
		String sql="insert into circle (id,name)value(:id,:name)";
		SqlParameterSource namedParam = new MapSqlParameterSource("id",circle.getId())
													.addValue("name",circle.getName());
		namedPjdbcTemplate.update(sql, namedParam);
	}
	
	public void createTriangle()
	{
		String sql ="create table triangle(id int,name char(50))";
		jdbcTemplate.execute(sql);
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedPjdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

		public NamedParameterJdbcTemplate getNamedPjdbcTemplate() {
		return namedPjdbcTemplate;
	}


	public void setNamedPjdbcTemplate(NamedParameterJdbcTemplate namedPjdbcTemplate) {
		this.namedPjdbcTemplate = namedPjdbcTemplate;
	}

		private  static final class CircleMapper implements RowMapper<Circle>{

			public Circle mapRow(ResultSet restulSet, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Circle circle =new Circle();
				circle.setId(restulSet.getInt("id"));
				circle.setName(restulSet.getString("name"));
				return circle;
			}
			
		}
}
