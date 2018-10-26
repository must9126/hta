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
		vBox.setAlignment(Pos.CENTER);  //��ư�� ���Ϳ� ��ġ
		
		Button button = new Button("������"); // ��ư ���� �� ǥ��
		
		Alert alert = new Alert(AlertType.CONFIRMATION);  // ok cancle ����� confirmation
		alert.setTitle("�˸�â");
		alert.setContentText("java Fx������");
		alert.setHeaderText("�޽���");
	//	alert.show();
		
		
		
		
		
//		button.setOnAction(new EventHandler<ActionEvent>() {  //��ư�� �̺�Ʈ
//			
//			@Override
//			public void handle(ActionEvent event) 
//			{
//				// TODO Auto-generated method stub
//				System.out.println("�������ϴ�.");
//				
//			}
//		});
		
		button.setOnAction		//�� �ּ��� �̷��� ���ٽ����� ��� �� ���� �ִ�.
		(ee->
			{
				System.out.println("�������ϴ�.");
				alert.show();
			}
		);  
		
		
		
		
		vBox.getChildren().add(button);
		
		Label lb =new Label("���̴�");
		Font font = new Font(50);  // ���⼭ �տ� "", �̰ɷ� �۾�ü�� �ٲܼ��ִ�.
		lb.setFont(font);
		
		
		Slider slider = new Slider();
		vBox.getChildren().add(lb); //�Ʒ� ���� ������
		vBox.getChildren().add(slider); // �� �Ʒ��� ĭ�� ������.
		
//		slider.valueProperty().addListener(new ChangeListener<Number>()         new ChangeListener ��ģ���� handler
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
									}); // ���� ���� ��ũ�� �������� addListener

		
		
		
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
