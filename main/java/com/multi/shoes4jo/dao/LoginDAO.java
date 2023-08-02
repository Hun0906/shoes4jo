package com.multi.shoes4jo.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataFactory;

	public LoginDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/mysqlpool");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String id, String pw) {
		String SQL = "SELECT count(*) FROM member WHERE MEMBER_ID = ? and MEMBER_PW = ?";
		try {
			conn = dataFactory.getConnection();

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return Integer.parseInt(rs.getString(1)); //id, pw가 모두 맞으면 1, 하나라도 틀리면 0
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //오류 시 -1
	}
}
