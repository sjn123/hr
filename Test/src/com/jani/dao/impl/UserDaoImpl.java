package com.jani.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jani.bean.User;
import com.jani.dao.UserDao;
import com.jani.utils.DBUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> query() {
		List<User> list =new ArrayList<User>();
		User user;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select id,user,password from test_exams;";
			try {
				conn=DBUtils.getConn();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					user=new User();
					user.setId(rs.getInt(1));
					user.setUser(rs.getString(2));
					user.setPassword(rs.getString(3));
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(rs, pstmt, conn);
			}
		return list;
	}
	
}
