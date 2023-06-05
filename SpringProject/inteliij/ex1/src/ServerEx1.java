import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1 {
    // bad code
    public static void main(String [] args) throws Exception {

        // 서버 소켓 준비 포트 필요
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("ServerSocket is Ready");

        // 연결 기다리다가 확인
        for(int i=0; i<100; i++) {
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket);

            // 읽기 위한 InputStream 이 필요
            InputStream in = clientSocket.getInputStream();
            // 3번 읽기
//            System.out.println(in.read());
//            System.out.println(in.read());
//            System.out.println(in.read());

            FileOutputStream fos = new FileOutputStream("C:\\zzz\\client"+i+".jpg");
            while (true) {
                int data = in.read();
                if(data == -1) {
                    break;
                }
                fos.write(data);
            } // end while
            in.close();
            fos.close();
            clientSocket.close();
        }
    }
}
