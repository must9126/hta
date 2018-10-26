package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FielChannelWriteMain 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

		// 파일채널 열기
		FileChannel channel = FileChannel.open
				(Paths.get("ppp/ccc.txt"),
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
		//  그 파일이 없으면 ccc 라는 이름의 txt확장자 파일을 만들고 
		//  그 파일이 있으면 수정할 수 있다.
		
		
		// 버퍼 생성
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("아기상어 뚜루루 뚜루 귀여운 asdf");
		
		
		// 파일에 쓰기1
		int cnt = channel.write(buf);
		channel.write(buf);
		// 한글은 2byte 씩 계산된다.  영어는 1byte
		System.out.println(cnt);
		
		buf=charset.encode("최강 전사 미니 특공대");
		
		//파일에 쓰기2
		cnt = channel.write(buf);
		System.out.println(cnt);
		
		//파일에 쓰기3
		cnt = channel.write(buf);  // 한번 작성한 buffer의 내용은 다시 사용할 수 없다.
		System.out.println(cnt);
		
		//파일채널 닫기
		channel.close();  // 만들고나서 우선 클로즈 하자
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
