package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			Statement stmt = con.createStatement();
			
			String sql ="select * from test2 " + 
					"where id <> 'fff'" + 
					"order by grade desc, id desc";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				Date reg_date = rs.getDate("reg_date");
				int grade = rs.getInt("grade");
				
				System.out.println("�� �л��̿���:"+id+","+reg_date+","+grade+">>>>");
			}
			
			rs.close();
			stmt.close();			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
