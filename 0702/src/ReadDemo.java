import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadDemo {
    public static void charNum() throws IOException {
        try(Scanner in = new Scanner(new FileInputStream(""),"utf-8")) {
            while (in.hasNext()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
    public static void byteNum() throws IOException {
        try(FileInputStream is = new FileInputStream("")) {
            byte[] bytes = new byte[1024];
            int n;
            while ((n = is.read(bytes)) != -1) {
                for (int i = 0; i < n; i++) {
                    System.out.println(bytes[i]);
                }
            }
        }
    }
}
