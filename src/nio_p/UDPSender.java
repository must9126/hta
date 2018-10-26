package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class UDPSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
										//IPV4 ���-StandardProtocolFamily.INET
			
			System.out.println("data ���۽���");
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("�� �����̿���");
			
			int cnt = channel.send(buf,new InetSocketAddress("192.168.0.2",7777));
			
			System.out.println("data ���ۿϷ�:"+cnt);
			
			channel.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
