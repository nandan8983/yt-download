package youtubedownload;

import java.io.PrintWriter;
/**
*
* @author Nandan
*/
import java.util.Scanner;

public class my_main {
	public static void main(String[] args) {
		Scanner a= new Scanner(System.in);
		String download_path="D:\\youtube_db_java";
		System.out.println("Give your link :-"); 
		String url=a.nextLine();
		
	
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command); 
		        new Thread(new Readlink(p.getErrorStream(), System.err)).start();
	                new Thread(new Readlink(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("cd \""+download_path+"\"");
	                stdin.println(download_path+"\\youtube-dl "+url);
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
	}	
}	