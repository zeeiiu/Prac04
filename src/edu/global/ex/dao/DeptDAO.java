package edu.global.ex.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.global.ex.vo.DeptVO;

public class DeptDAO {

//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String uid = "scott";
//	private String upw = "tiger";

	private DataSource dataSource; // DataSource is CP (Connection pool).반드시 외우기.

	public DeptDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");   // 서버에 세팅했기 때문에 주석 처리가능. 
//		} catch (Exception e) {                                 //driverClassName="oracle.jdbc.OracleDriver" (서버에 메모리 올라감)
//			e.printStackTrace();
//		}
//	}

		try {
			Context context = new InitialContext(); // 여기서의 Context는 서버에 있는 context.xml에 세팅되어있는 것을 끌고오기 위한 객체
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // lookup 찾아라. java:comp/env/ 는 자바에서
																					// 제공하는 지니 문법을 쓰겠다. fiX!
		} catch (Exception e) { // jdbc/oracle는 context.xml에 있는 name
			e.printStackTrace();
		}
	}

	public List<DeptVO> deptSelect() {
		List<DeptVO> vos = new ArrayList<DeptVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "Select * from dept";

//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				String dname = rs.getString("dname");

				DeptVO vo = new DeptVO(deptno, dname, loc);
				vos.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vos;

	}

}