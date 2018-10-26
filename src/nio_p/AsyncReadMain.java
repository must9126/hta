package nio_p;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class AttachGoGo2{
	Path path;
	AsynchronousFileChannel channel;
	ByteBuffer buf;
	
	AttachGoGo2(Path path, AsynchronousFileChannel channel,ByteBuffer buf) {
		super();
		this.path = path;
		this.channel = channel;
		this.buf = buf;
	}
	
	
}

public class AsyncReadMain {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		
		for(int i=0; i<10; i++) {
			Path path = Paths.get("nnn/aaa_"+i+".txt");
			
			AsynchronousFileChannel channel = 
					AsynchronousFileChannel.open(path, StandardOpenOption.READ);
			
			
			//파일크기를 받아 buf 공간 생성
			ByteBuffer buf = ByteBuffer.allocate((int)channel.size());
			
			AttachGoGo2 attach = new AttachGoGo2(path, channel, buf);
		}
	}

}
