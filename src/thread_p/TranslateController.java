package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController implements Initializable {

	@FXML Arc arc;
	@FXML Button start, pause, stop;
	
	TranslateTransition transition;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		transition = new TranslateTransition();
		
		///position
		transition.setFromX(500);	//����x��ġ
		transition.setFromY(100);	//����x��ġ
		transition.setToX(100);	//����x��ġ
		transition.setToY(400);	//����x��ġ
		
		transition.setDuration(new Duration(3000));//����ð�
		transition.setCycleCount(5);	//�ݺ�Ƚ��
		transition.setAutoReverse(true);
		
		transition.setNode(arc);		//������ node
		transition.play();
		
		pause.setOnAction(ee->{
			transition.pause();
			System.out.println(transition.getStatus());
		});
		start.setOnAction(ee->{
			transition.play();
			System.out.println(transition.getStatus());
		});
		stop.setOnAction(ee->{
			transition.stop();
			System.out.println(transition.getStatus());
		});
	}

}
