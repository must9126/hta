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

public class BuckdolController implements Initializable
{

	@FXML AnchorPane anchorp;
	@FXML Pane barp, ballp;
	
	boolean end=false;
	
	double barx=0;
	double bary=0;
	
	double ballx=0;
	double bally=0;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub

		Timer2 timer = new Timer2();
		timer.setDaemon(true);
		timer.start();
		
		

	//focusTraversable="true" node가 focus를 인지하지 않고 관통시키는 것
    ///    keyEvent의 주체가 되지 않도록 설정	
	/////이벤트 등록   ----> 키입력 이벤트 (KEY_PRESSED, KEY_RELEASED, KEY_TYPED)
		anchorp.addEventHandler(KeyEvent.KEY_PRESSED, 
			new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent key) 
				{
					// TODO Auto-generated method stub
					//System.out.println(key.getCode());
					
					
					
					
					if(key.getCode()==KeyCode.UP) 
					{
						bary = barp.getLayoutY()-5;
						
						if(bary<0) bary=0;

						barp.setLayoutY(bary);
					}
					
					if(key.getCode()==KeyCode.DOWN) 
					{
						bary = barp.getLayoutY()+5;
						
						if(anchorp.getPrefHeight()<bary+barp.getPrefHeight()) 
							bary=anchorp.getPrefHeight()-barp.getPrefHeight();
						
						
						barp.setLayoutY(bary);
					}
					
					if(key.getCode()==KeyCode.LEFT) 
					{
						barx = barp.getLayoutX()-5;
						
						if(barx<0) barx=0;

						barp.setLayoutX(barx);
					}
					
					if(key.getCode()==KeyCode.RIGHT) 
					{
						barx = barp.getLayoutX()+5;
						
						if(anchorp.getPrefWidth()<barx+barp.getPrefWidth()) 
							barx=anchorp.getPrefWidth()-barp.getPrefWidth();
						
						
						barp.setLayoutX(barx);
					}
					
					
					
				}

		});
		
		
	}
	
	class Timer2 extends Thread
	{
		@Override
		public void run() 
		{
			
			// TODO Auto-generated method stub
			while(true) 
			{
				try 
				{
//					if(end==true) 
//					{
//						break;
//					}
					Platform.runLater(()->init());
					sleep(30);
					
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	int disX=5, disY=5;
	
	void init() 
	{
		ballx = ballp.getLayoutX()+disX;
		
		if(anchorp.getPrefWidth()<ballx+ballp.getPrefWidth() ||
				ballx<0 ) 
		{
			disX*=-1;
		}

		ballp.setLayoutX(ballx);
		
		bally = ballp.getLayoutY()+disY;
		
		if(
				( anchorp.getPrefHeight()<bally+ballp.getPrefHeight() || bally<0 ) ||  
				( (ballx+40<=(barx+40+(barp.getPrefWidth()/2))+(barp.getPrefWidth()/2) ) &&
				(  (ballx+40>(barx+40+(barp.getPrefWidth()/2))-(barp.getPrefWidth()/2))) )&&
				( (bally+40>bary+100) )
				  ) 
		{
			
			
			disY*=-1;
			
		}

		ballp.setLayoutY(bally);
		
		//               오른쪽                                                                   왼쪽
//		if( ( (ballx<=barx+(barp.getPrefWidth()/2)) && (ballx>barx-(barp.getPrefWidth()/2)) ) &&
//			( (bally<=bary+(barp.getPrefHeight()/2)) && (bally>bary-(barp.getPrefHeight()/2)) )	
//		  )
//		{
//			
//		//	end=true;
//		
//		//	user.setVisible(false);
//			
//			System.out.println("충돌");
//		}
		
		if( ( (ballx<=(barx+(barp.getPrefWidth()/2))+(barp.getPrefWidth()/2) ) &&( (ballx>barx ) ) )&&
				( (bally<=(bary+(barp.getPrefHeight()/2))+(barp.getPrefHeight()/2) ) &&( (bally>bary+10 ) ) )
		  )
			{
				
//			ballx = ballp.getLayoutX()+disX;
//			
//			if(barp.getPrefWidth()<ballx+ballp.getPrefWidth() ||
//					ballx<0 ) 
//			{
//				disX*=-1;
//			}
//
//			ballp.setLayoutX(ballx);
			
			bally = ballp.getLayoutY()+disY;
			
			if(barp.getPrefHeight()<bally+ballp.getPrefHeight() ||
					bally<0 ) 
			{
				disY*=-1;
			}

			ballp.setLayoutY(bally);
				
	//			System.out.println("충돌");
			}
		
	}

}
