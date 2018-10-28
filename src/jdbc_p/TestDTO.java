package jdbc_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDTO 
{

	String id;
	Date reg_date;
	int grade;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public TestDTO()
	{
		// TODO Auto-generated constructor stub
	}
	

	public TestDTO(String id, String reg_date, int grade) 
	{
		super();
		this.id = id;
		try 
		{
			this.reg_date = sdf.parse(reg_date);
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.grade = grade;
	}

	public String reg_dateStr()
	{
		return sdf.format(reg_date);
	}

	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public Date getReg_date()
	{
		return reg_date;
	}
	public void setReg_date(Date reg_date)
	{
		this.reg_date = reg_date;
	}
	public int getGrade() 
	{
		return grade;
	}
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	@Override
	public String toString()
	{
		return id + ", " + reg_date + ", " + grade;
	}
	
	
}
