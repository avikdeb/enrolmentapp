package com.avik.enrolmentapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.avik.enrolmentapp.beans.Role;
import com.avik.enrolmentapp.manager.AppDBConnectionMgr;

public class RoleDAO {
	
	private int idrole;
	private String role;
	private String desc;
	
	public RoleDAO() {
		
		idrole = 0;
		role = "";
		desc = "";
	}
	
	public Role getRoleById(int roleid) {
		
		Role role = new Role();
		String roleSQL = "select * from enrolmentapp.role where role.idrole="+roleid;
		System.out.println("Role SQL --> "+roleSQL);
		AppDBConnectionMgr mgr = AppDBConnectionMgr.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = mgr.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(roleSQL);
			if(rs.next()) {
				role.setIdrole(rs.getInt("idrole"));
				role.setRole(rs.getString("role"));
				role.setDesc(rs.getString("desc"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mgr.closeConnection(con);
		}
		
		return role;
	}

	public Role getRoleByName(String rolename) {
		
		Role role = new Role();
		String roleSQL = "select * from enrolmentapp.role where role.role='"+rolename+"'";
		System.out.println("Role SQL --> "+roleSQL);
		AppDBConnectionMgr mgr = AppDBConnectionMgr.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = mgr.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(roleSQL);
			if(rs.next()) {
				role.setIdrole(rs.getInt("idrole"));
				role.setRole(rs.getString("role"));
				role.setDesc(rs.getString("desc"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mgr.closeConnection(con);
		}
		
		return role;
	}

}
