import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class PageGenerator{

	public static void main(String[] args) throws IOException{

      String title="";
      String speaker="";
      String date="";
      String scriptList="";
      
      try {
			 File file = new File("sermonInfo.txt");
			 FileReader fileReader = new FileReader(file);
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 StringBuffer stringBuffer = new StringBuffer();
			 String line;
			 if ((line = bufferedReader.readLine()) != null) {
	              title = line;
	          }
	          if ((line = bufferedReader.readLine()) != null) {
	        	  speaker = line;
	          }
	          if ((line = bufferedReader.readLine()) != null) {
	        	  date = line;
	          }
	          if ((line = bufferedReader.readLine()) != null) {
	        	  scriptList = line;
	          }
			 fileReader.close();
			 System.out.println(title+"\n"+speaker+"\n"+date+"\n"+scriptList);
		} catch (IOException e) {
			e.printStackTrace();
		}
   
      

      String scripts = "Hello World\n";

      try(  PrintWriter out = new PrintWriter( date+".txt")  ){
    	    out.print("<!doctype html>\n<html>\n<head>\n<meta charset=\"utf-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n<title>");
    	    out.print(title + " by " + speaker + " " + date +"</title>\n");
    	    out.print("<style type=\"text/css\">\n.Verse {\n}\n</style>\n<link href=\"sermonPost.css\" rel=\"stylesheet\" type=\"text/css\">\n</head>\n\n<body>\n <div align=center>\n   <span id=\"title\"><strong>");
    	    out.print(title);
    	    out.print("</strong></span><br>\n   <span id=\"author\"><strong>");
    	    out.print(speaker);
    	    out.print("</strong></span><br>\n   <span id=\"date\">");
    	    out.print(date);
    	    out.print("</span>\n</div>\n <div align=center>\n <p>\n<img src=\"");
    	    out.print(date+".jpg\"");
    	    out.print(" width=\"100%\" alt=\"\"/>\n	</p>\n	</div>\n<p><span id=\"section\" align=left>音频：</span>\n  <span id=\"download\"><a href=\"");
    	    out.print(date);
    	    out.print(".mp3\" download=\"");
    	    out.print(date);
    	    out.print(".mp3\" style=\"color:red\">下载</a></span>\n</p>\n<div id=\"audio\" align=center>\n   <script type=\"text/javascript\" >\n     var mp3snd = \"");
    	    out.print(date);
    	    out.print(".mp3\";\n   </script>\n   <script type=\"text/javascript\" src=\"audioSermons.js\"></script>\n</div>\n\n<p><span id=\"section\" >经文：</span></p>\n<div id=\"verse\">\n\n");
    	    out.print("  "+scriptList+" Chinese Union Version (Simplified) (CUVS)\n\n");
    	    
    	    try {
	   			 File file = new File("scripts.txt");
	   			 FileReader fileReader = new FileReader(file);
	   			 BufferedReader bufferedReader = new BufferedReader(fileReader);
	   			 StringBuffer stringBuffer = new StringBuffer();
	   			 String line;
	   			 while ((line = bufferedReader.readLine()) != null) {
	   				 out.print("<p> "+line + "</p>\n");
	   	          }
	   	         
	   			 fileReader.close();
	   			 System.out.println("scripts done!");
	   		} catch (IOException e) {
	   			e.printStackTrace();
	   		}

    	    out.print("\n</div>\n<br>\n\n<div id=\"footnote\" align=center>\n <p>扫描二维码关注\"BCBCSermon\"<br>公共号收听更多信息<br>\n<img src=\"qrcode_for_bcbcsermon.jpg\" width=\"60%\" alt=\"\"/>\n	</p>\n	</div>\n</body>\n</html>");
    	}
      catch (FileNotFoundException e){
    	  
      }      
     
      
    }
}
