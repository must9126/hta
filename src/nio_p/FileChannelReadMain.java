package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadMain 
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub

		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt")
				, StandardOpenOption.READ
				 );
		
		// 가지고 올 데이터 크기를 모르므로 충분한 buffer 크기를 확보하자
		ByteBuffer buf = ByteBuffer.allocate(20);
		
		Charset charset = Charset.defaultCharset();
		
		int cnt=0;
		
		
		String data="";
		
		while(true) 
		{
			cnt= channel.read(buf);
			
			if(cnt==-1)    //-1 이 리턴되면 channel 에서
						  // 가져올 data가 마지막이라는 것을 의미한다
				break;
			
			buf.flip();  //decode 하기 전에 flip을 해서 읽어주는 위치를 바꿔주자.
			data+=charset.decode(buf);
			
			
			buf.clear();   // 다쓴 buf 공간은 지운다.
			
		}
		
		
		channel.close();
		
		System.out.println(data);
		
		
		
	}

}
