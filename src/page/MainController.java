package page;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

	//데이터를 갖는게 주목적  리턴도 받아야한다.
	// 절대 죽이면 안된다. 죽이면 데이터가 다 날라감
	//ex 국영수 시험을 본다 치면 이친구가 최종 점수를 다 리턴받아야한다.
	
	
	@FXML Button mainBtn;
	
	@FXML TextField msg;
	
	@FXML Label label;


	MainController me;
	
	public void subGo() {
		
		try {
			
			///기존 layout 의 AnchorPane에다가 sub를 덮어쓰기ㄴ
			AnchorPane root=  (AnchorPane)mainBtn.getScene().getRoot();	
			          //기존 Parent 인 AnchorPane(layout)을 가져옴
			
			me = this;///mainController 자기 자신을 멤버변수로 대입
			
			///sub layout
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							
							HashMap<String, Object>map = new HashMap<>();
							
							map.put("hi", "석태진 확 그냥");
							map.put("main", me);
							
							return map.get(key);  ///key에 해당하는 value return
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});
			
			root.getChildren().add(sub);
			
			//기존 layout 의 하위로 sub_layout 을 요소로 추가
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		if(resources!=null)
			label.setText("From Sub :"+resources.getObject("").toString());
	}

}
