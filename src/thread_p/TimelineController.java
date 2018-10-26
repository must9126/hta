package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TimelineController implements Initializable {

	@FXML Arc arc;
	@FXML Button btn1, btn2;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btn1.setOnAction(ee->{
			
			Timeline tl = new Timeline();
			
			KeyFrame x_0 = new KeyFrame(
					new Duration(0), 
					new KeyValue(arc.layoutXProperty(), 50)
					);
			KeyFrame y_0 = new KeyFrame(
					new Duration(0), 
					new KeyValue(arc.layoutYProperty(), 50)
					);
			
			KeyFrame x_1 = new KeyFrame(
					new Duration(1000), 
					new KeyValue(arc.layoutXProperty(), 100)
					);
			KeyFrame y_1 = new KeyFrame(
					new Duration(1000), 
					new KeyValue(arc.layoutYProperty(), 50)
					);
			
			
			KeyFrame y_2 = new KeyFrame(
					new Duration(2000), //////Duration �ð��� �ſ� �߿���
					new KeyValue(arc.layoutYProperty(), 200)  //���°����� ó��
					);
			
			////add ������ keyframe ������ �������
			tl.getKeyFrames().add(y_0);
			tl.getKeyFrames().add(y_1);
			tl.getKeyFrames().add(y_2);
			tl.getKeyFrames().add(x_0);
			tl.getKeyFrames().add(x_1);
			
			//tl.setCycleCount(3);
			tl.setCycleCount(-1);		//���ѹݺ�
			tl.setAutoReverse(true);
			
			tl.play();
			
			
		});
	}

}
