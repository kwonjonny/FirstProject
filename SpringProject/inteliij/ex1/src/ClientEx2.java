import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientEx2 {
    // bad code
    public static void main(String [] args) throws Exception {

        Socket socket = new Socket("192.168.0.48", 8080);

        InputStream in = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream("C:\\zzz\\server.jpg");

        while(true) {
            int data = in.read();
            if(data == -1) {
                break;
            }
            fos.write(data);
        } // end while
        in.close();
        fos.close();
        socket.close();

    }
}
