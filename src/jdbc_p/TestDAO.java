package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestDAO
{

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public TestDAO() 
	{
		// TODO Auto-generated constructor stub
		try 
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			stmt = con.createStatement();
			
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public ArrayList<TestDTO> list()
	{
		
		ArrayList<TestDTO> res = new ArrayList<>();
		
		sql = "select * from test2";
		
		try
		{
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				TestDTO dto = new TestDTO();
				
				dto.id = rs.getString("id");
				dto.reg_date = rs.getDate("reg_date");
				dto.grade = rs.getInt("grade");
				
				res.add(dto);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally 
		{
			close();
		}

		return res;
		
	}
	
	// id 하나만 추가
	public TestDTO detail(String id)
	{
		
		TestDTO dto = null;
		sql = "select * from test2 where id = '"+id+"'";
		try
		{			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) 
			{
				dto = new TestDTO();	
				dto.id = rs.getString("id");
				dto.reg_date = rs.getDate("reg_date");
				dto.grade = rs.getInt("grade");
			}
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			close();
		}

		return dto;	
	}
	
	
	//insert
	public int insert(TestDTO dto)
	{
		
		int res =0;
		sql = "insert into test2 (id, REG_DATE,grade) values ('"
		+ dto.id       +"','"
		+ dto.reg_dateStr() +"',"
		+ dto.grade    +")";
		
		System.out.println(sql);
		
		try
		{			
			res = stmt.executeUpdate(sql);
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close();
		}

		return res;	
	}
	
	
	//modify == update ( 수정 )
		public int modify(TestDTO dto)
		{
			
			int res =0;
			sql = "update test2 set grade = "
					+dto.grade+", reg_date ='"
					+dto.reg_dateStr()+"' where id = '"
					+dto.id+"'";
			
			System.out.println(sql);
			
			try
			{			
				res = stmt.executeUpdate(sql);
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			finally {
				close();
			}

			return res;	
		}
	
	
	
		//delete ( 삭제 )
				public int delete(String id)
				{
					
					int res =0;
					sql = "delete from test2 where id='"+id+"'";
					
					System.out.println(sql);
					
					try
					{			
						res = stmt.executeUpdate(sql);
						
					} 
					catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					finally {
						close();
					}

					return res;	
				}
		
		
	
	
	public void close() 
	{
		if(rs!=null) try {rs.close();} catch (SQLException e) {}
		if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
		if(con!=null) try {con.close();} catch (SQLException e) {}
		
	}
	
	
	
}
