package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	
	//���� ���� main -> ������ -> init -> start -> â�� ������ stop
	
	
	public Main() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("������");
	}
	
	

	@Override
	public void init() throws Exception   //�����͸� ������
	{
		// TODO Auto-generated method stub
		System.out.println("init��");
	}



	@Override
	public void stop() throws Exception //���߸鼭 ������ �����Ѵ�.
	{
		// TODO Auto-generated method stub
		System.out.println("�״´�");
		Sub.main(new String [] {});
	}



	@Override
	public void start(Stage primaryStage) {  //�׸��� ����
		try {
			
			System.out.println("start��");
			//primaryStage �ȿ�-> scene �ȿ�-> root
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("�� �����̴�");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("main�̴�");  
		launch(args); // �̰� �־�� â�� �����ִ�. launch�� ��ŸƮ�� ����
	}
}
