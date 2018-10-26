package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BtnMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// TODO Auto-generated method stub

		
		VBox vBox = new VBox();
		vBox.setPrefWidth(700);
		vBox.setPrefHeight(400);
		vBox.setAlignment(Pos.CENTER);  //버튼을 센터에 위치
		
		Button button = new Button("눌러바"); // 버튼 생성 후 표기
		
		Alert alert = new Alert(AlertType.CONFIRMATION);  // ok cancle 만드는 confirmation
		alert.setTitle("알림창");
		alert.setContentText("java Fx이지롱");
		alert.setHeaderText("메시지");
	//	alert.show();
		
		
		
		
		
//		button.setOnAction(new EventHandler<ActionEvent>() {  //버튼의 이벤트
//			
//			@Override
//			public void handle(ActionEvent event) 
//			{
//				// TODO Auto-generated method stub
//				System.out.println("눌렀습니다.");
//				
//			}
//		});
		
		button.setOnAction		//위 주석을 이렇게 람다식으로 사용 할 수도 있다.
		(ee->
			{
				System.out.println("눌렀습니다.");
				alert.show();
			}
		);  
		
		
		
		
		vBox.getChildren().add(button);
		
		Label lb =new Label("라벨이당");
		Font font = new Font(50);  // 여기서 앞에 "", 이걸로 글씨체를 바꿀수있다.
		lb.setFont(font);
		
		
		Slider slider = new Slider();
		vBox.getChildren().add(lb); //아래 라벨이 나오고
		vBox.getChildren().add(slider); // 그 아래로 칸이 나뉜다.
		
//		slider.valueProperty().addListener(new ChangeListener<Number>()         new ChangeListener 이친구가 handler
//		{
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
//			{
//				// TODO Auto-generated method stub
//				System.out.println(newValue);
//			}
//		});
		
		slider.valueProperty().addListener(
				(ObservableValue<? extends Number> observable
				, Number oldValue
				, Number newValue)->
									{
										lb.setText(newValue+"");
									//	Font font2 = new Font(20);
										lb.setFont(new Font(newValue.doubleValue()));
									
									//	System.out.println(newValue);
									}); // 볼륨 설정 스크롤 느낌나는 addListener

		
		
		
		Scene scene = new Scene(vBox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		launch(args);
	}

}
