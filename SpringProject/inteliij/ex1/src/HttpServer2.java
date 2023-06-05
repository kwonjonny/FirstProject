import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpServer2 {

    // bad Code
    public static void main(String[] args)throws Exception {

        Map<String, String> mimeMap = new HashMap<>();

        mimeMap.put("jpg", "image/jpeg");
        mimeMap.put("html", "text/html");

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Ready...");

        for (int i = 0; i < 100; i++) {

            Socket client = serverSocket.accept();
            System.out.println(client);

            InputStream in = client.getInputStream();

            Scanner scanner = new Scanner(in);
            String firstLine = scanner.nextLine();

            System.out.println(firstLine);

            String[] arr = firstLine.split(" ");

            // file name => /m1.jpg
            String fileName = arr[1];

            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
            System.out.println(suffix);

            OutputStream out = client.getOutputStream();


            File file = new File("C:\\zzz"+fileName);

            long size = file.length();


            // HTTP Header
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

            out.write(new String("Cache-Control: private\r\n").getBytes());

            // 이미지의 사이즈
//            out.write(new String("Content-Length: "+size+"\r\n").getBytes());

            // 보낼 데이터의 type
            out.write(new String("Content-Type:"+mimeMap.get(suffix)+"\r\n\r\n").getBytes()); // => MIME

            FileInputStream fin = new FileInputStream(file);

            byte[] buffer = new byte[1024*8];

            while(true){
                int count = fin.read(buffer);

                if(count == -1){
                    break;
                }
                out.write(buffer,0,count);
            }

//            in.close();
//            out.close();
//            client.close();

        }// end for

    }
}