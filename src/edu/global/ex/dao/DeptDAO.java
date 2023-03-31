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

	private DataSource dataSource; // DataSource is CP (Connection pool).�ݵ�� �ܿ��.

	public DeptDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");   // ������ �����߱� ������ �ּ� ó������. 
//		} catch (Exception e) {                                 //driverClassName="oracle.jdbc.OracleDriver" (������ �޸� �ö�)
//			e.printStackTrace();
//		}
//	}

		try {
			Context context = new InitialContext(); // ���⼭�� Context�� ������ �ִ� context.xml�� ���õǾ��ִ� ���� ������� ���� ��ü
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // lookup ã�ƶ�. java:comp/env/ �� �ڹٿ���
																					// �����ϴ� ���� ������ ���ڴ�. fiX!
		} catch (Exception e) { // jdbc/oracle�� context.xml�� �ִ� name
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