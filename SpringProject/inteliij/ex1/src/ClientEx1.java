import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEx1 {
    // bad code exception
    public static void main(String [] args) throws Exception {

        Socket socket = new Socket("192.168.0.154", 8080);
        System.out.println(socket);

        // 보내려면 OutputStream 이 필요하다
        OutputStream outputStream = socket.getOutputStream();

//        outputStream.write(56);
//        outputStream.write(56);
//        outputStream.write(56);

        // file data 보내기
        FileInputStream fin = new FileInputStream("C:\\zzz\\손흥민.jpg");

        // 계속 읽고 보내기
        while(true) {
            // 1바이트 내용물
            int data = fin.read();
            // 내용물 전송
            outputStream.write(data);

            // if -1 종료
            if(data == -1) {
                break;
            }
        } // end while
        // 사용했던 자원 정리
        fin.close();
        outputStream.close();
        socket.close();
    }
}
