import java.io.*;

public class WriteDemo {
    public static void charNum() throws IOException {
       try(FileOutputStream os = new FileOutputStream("")) {
           try(OutputStreamWriter ow = new OutputStreamWriter(os,"utf-8")) {
               try(PrintWriter pw = new PrintWriter(ow)) {
                   pw.println(1);
                   pw.flush();
               }
           }
       }
       try(PrintWriter printWriter = new PrintWriter(
               new OutputStreamWriter(new FileOutputStream(""),"utf-8")
       )){
           printWriter.println();
           printWriter.flush();
       }
    }
    
}
