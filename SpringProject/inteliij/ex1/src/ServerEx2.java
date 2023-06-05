import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx2 {

    //bad code
    public static void main(String[] args) throws Exception {

        //서버소켓 준비
        ServerSocket serverSocket = new ServerSocket(8080);

        while(true){
            Socket client = serverSocket.accept();
            System.out.println(client);
            //파일 데이터 전송
            FileInputStream fin = new FileInputStream("C:\\zzz\\test.jpg");
            //데이터 전송용 out
            OutputStream out = client.getOutputStream();

            byte[] buffer = new byte[1024*8];//8kb

            long start = System.currentTimeMillis();

            while(true){
//                int data = fin.read();
//                if(data == -1){break;}
//                out.write(data);
                int count = fin.read(buffer);
                if(count == -1) {break;}
                out.write(buffer,0,count);
            }
            long end = System.currentTimeMillis();

            System.out.println(end - start);

            out.close();
            fin.close();
            client.close();
        }
        //accept( ) 클라이언트 접속


        //읽기 쓰기

        //close()

    }
}