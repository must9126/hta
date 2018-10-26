package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	
	//실행 순서 main -> 생성자 -> init -> start -> 창을 닫으면 stop
	
	
	public Main() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("생성자");
	}
	
	

	@Override
	public void init() throws Exception   //데이터를 받을때
	{
		// TODO Auto-generated method stub
		System.out.println("init다");
	}



	@Override
	public void stop() throws Exception //멈추면서 닫음을 실행한다.
	{
		// TODO Auto-generated method stub
		System.out.println("죽는닷");
		Sub.main(new String [] {});
	}



	@Override
	public void start(Stage primaryStage) {  //그리는 역할
		try {
			
			System.out.println("start다");
			//primaryStage 안에-> scene 안에-> root
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("와 제목이당");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("main이다");  
		launch(args); // 이게 있어야 창을 열수있다. launch가 스타트를 연다
	}
}
