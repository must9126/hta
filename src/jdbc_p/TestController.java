package jdbc_p;

public class TestController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("list >>>");
		for (TestDTO dto : new TestDAO().list()) {
			System.out.println(dto);
		}
		System.out.println("detail >>>");
		System.out.println(new TestDAO().detail("ccc"));
		System.out.println(new TestDAO().detail("bbb"));
		
		System.out.println("insert >>>");
		TestDTO dto = new TestDTO("www", "2011-11-11", 5);
		System.out.println(new TestDAO().insert(dto));
	}

}
