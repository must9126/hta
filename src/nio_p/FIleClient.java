package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FIleClient 
{
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			
			
			
			SocketChannel channel = SocketChannel.open();
			channel.configureBlocking(true);
			
			channel.connect(new InetSocketAddress("192.168.0.59", 7777));
			
			Path path = Paths.get("nnn/ssss.jpg");
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			channel.read(buf);  // ���� max ������ �κ��� FileChannel�� ������
								// buf�� ��ƸԾ ������ �뷮�� ���� �� ���Եȴ�.
			buf.flip();
			int xx = 0;
			xx=buf.getInt();
			buf.clear();
			
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
			
			
			for (int i = 0; i < xx; i++) 
			{
				int cnt = channel.read(buf);
				buf.flip();
				fc.write(buf);
				buf.clear();
				System.out.println("client:"+cnt);
				
			}
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
