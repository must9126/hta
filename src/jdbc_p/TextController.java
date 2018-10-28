package jdbc_p;

public class TextController
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		for (TestDTO dto : new TestDAO().list())
		{
			System.out.println(dto);
		}
		
		System.out.println("detail >>>");
		System.out.println(new TestDAO().detail("ccc"));
		System.out.println(new TestDAO().detail("bbb"));  // 변수가 없으면 null로 나온다.
		
//		System.out.println("insert >>>");
//		TestDTO dto = new TestDTO("www", "2011-11-11", 5);
//		System.out.println(new TestDAO().insert(dto));
		
		System.out.println("modify >>>");
		TestDTO dto = new TestDTO("www", "2017-07-07", 7);
		System.out.println(new TestDAO().modify(dto));
		
		System.out.println("delete >>>");
		System.out.println(new TestDAO().delete("www"));
		
	}

}
