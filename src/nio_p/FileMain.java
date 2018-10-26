package nio_p;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Path pp = Paths.get("ppp");
		
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
	//	System.out.println(Files.newDirectoryStream(pp));
		
		
		// ppp 폴더안에 있는 모든 자료와 자료형을 알수있다. 파일의 크기, 수정된 날짜 를 알수있다.
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		
		for(Path path : ds) 
		{
			System.out.print(Files.getLastModifiedTime(path)+"\t");
			if(Files.isDirectory(path)==true)
			{
				System.out.print("<DIR>"+"\t");
			}
			else 
			{
				System.out.print("\t");
			}
		//	System.out.println(path);
			System.out.print("파일명 : "+path.getFileName()+"\t");
			System.out.println();
		}
		
		
		
		
		System.out.println("----------------------");
		
		pp = Paths.get("ppp/son.jpg");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.getLastModifiedTime(pp));
		System.out.println(Files.size(pp));
		System.out.println(Files.getOwner(pp));
		System.out.println(Files.isHidden(pp));
		System.out.println(Files.isReadable(pp));
		System.out.println(Files.isWritable(pp));
		System.out.println("파일명:"+pp.getFileName());
		System.out.println("현재디렉토리명:"+pp.getParent().getFileName());
		System.out.println("디렉토리 경로수:"+pp.getNameCount());
		
		
		System.out.println();
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i));
		}
		
		
		
		
		System.out.println("-----------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
	}

}
