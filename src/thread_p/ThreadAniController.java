package thread_p;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class ThreadAniController implements Initializable {

	@FXML AnchorPane totalP;
	@FXML Pane pp, user;
	@FXML Arc pArc;
	
	double useryy=0;
	double userxx=0;
	
	double ppyy=0;
	double ppxx=0;
	
	
	boolean end=false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		
		

	//focusTraversable="true" node가 focus를 인지하지 않고 관통시키는 것
    ///    keyEvent의 주체가 되지 않도록 설정	
	/////이벤트 등록   ----> 키입력 이벤트 (KEY_PRESSED, KEY_RELEASED, KEY_TYPED)
		totalP.addEventHandler(KeyEvent.KEY_PRESSED, 
			new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent key) {
					// TODO Auto-generated method stub
					//System.out.println(key.getCode());
					
					
					
					
					if(key.getCode()==KeyCode.UP) {
						useryy = user.getLayoutY()-5;
						
						if(useryy<0) useryy=0;

						user.setLayoutY(useryy);
					}
					
					if(key.getCode()==KeyCode.DOWN) {
						useryy = user.getLayoutY()+5;
						
						if(totalP.getPrefHeight()<useryy+user.getPrefHeight()) 
							useryy=totalP.getPrefHeight()-user.getPrefHeight();
						
						
						user.setLayoutY(useryy);
					}
					
					if(key.getCode()==KeyCode.LEFT) {
						userxx = user.getLayoutX()-5;
						
						if(userxx<0) userxx=0;

						user.setLayoutX(userxx);
					}
					
					if(key.getCode()==KeyCode.RIGHT) 
					{
						userxx = user.getLayoutX()+5;
						
						if(totalP.getPrefWidth()<userxx+user.getPrefWidth()) 
							userxx=totalP.getPrefWidth()-user.getPrefWidth();
						
						
						user.setLayoutX(userxx);
					}
					
					
					
				}

		});
	}
	
	
	
	
	
	class Timer extends Thread{
		@Override
		public void run() {
			
			// TODO Auto-generated method stub
			while(true) {
				try {
					if(end==true) 
					{
						break;
					}
					Platform.runLater(()->init());
					sleep(30);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	int disX = 5,  disY = 5;
	void init() {
		ppxx = pp.getLayoutX()+disX;
		
		if(totalP.getPrefWidth()<ppxx+pp.getPrefWidth() ||
				ppxx<0 ) {
			disX*=-1;
		}

		pp.setLayoutX(ppxx);
		
		ppyy = pp.getLayoutY()+disY;
		
		if(totalP.getPrefHeight()<ppyy+pp.getPrefHeight() ||
				ppyy<0 ) {
			disY*=-1;
		}

		pp.setLayoutY(ppyy);
		
		//               오른쪽                                                                   왼쪽
		if( ((userxx<=ppxx+pp.getPrefWidth()/2) && (userxx>ppxx-pp.getPrefWidth()/2)) &&
			((useryy<=ppyy+pp.getPrefHeight()/2) && (useryy>ppyy-pp.getPrefHeight()/2))	
		  )
		{
			
		//	end=true;
		
		//	user.setVisible(false);
			
			
			
			
			System.out.println("충돌");
		}
		
	}

}
