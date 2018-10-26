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

		// ����ä�� ����
		FileChannel channel = FileChannel.open
				(Paths.get("ppp/ccc.txt"),
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
		//  �� ������ ������ ccc ��� �̸��� txtȮ���� ������ ����� 
		//  �� ������ ������ ������ �� �ִ�.
		
		
		// ���� ����
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("�Ʊ��� �ѷ�� �ѷ� �Ϳ��� asdf");
		
		
		// ���Ͽ� ����1
		int cnt = channel.write(buf);
		channel.write(buf);
		// �ѱ��� 2byte �� ���ȴ�.  ����� 1byte
		System.out.println(cnt);
		
		buf=charset.encode("�ְ� ���� �̴� Ư����");
		
		//���Ͽ� ����2
		cnt = channel.write(buf);
		System.out.println(cnt);
		
		//���Ͽ� ����3
		cnt = channel.write(buf);  // �ѹ� �ۼ��� buffer�� ������ �ٽ� ����� �� ����.
		System.out.println(cnt);
		
		//����ä�� �ݱ�
		channel.close();  // ������� �켱 Ŭ���� ����
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
