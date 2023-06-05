import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer1 {

    // bad Code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Ready...");

        for (int i = 0; i < 100; i++) {

            Socket client = serverSocket.accept();
            System.out.println(client);

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();


            String msg = "<h1>주용이는 천재다"+i+"</h1>";

            // HTTP Header
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+msg.getBytes("UTF-8").length+"\r\n").getBytes());
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes()); // => MIME

            out.write(msg.getBytes(StandardCharsets.UTF_8));


            in.close();
            out.close();
            client.close();

        }// end for

    }
}