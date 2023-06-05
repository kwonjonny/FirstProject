import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Main {
    // bad code
    public static void main(String[] args) throws Exception {

        // copy 작업
        URL url = new URL("https://img.megabox.co.kr/SharedImg/2023/06/01/IkRZmlSpR5iDXq6qJizktYQGhpRHmihs_420.jpg");

        InputStream fin = url.openStream();


        // 1단계 : output input 준비
//        FileInputStream fin = new FileInputStream("C:\\zzz\\손흥민.jpg");

        FileOutputStream fos = new FileOutputStream("C:\\zzz\\copy.jpg");

//        System.out.println("INPUT : "+fin);


        // 2단계 : 읽고 쓰기
        while (true) {
            int data = fin.read();
            if(data == -1){
                break;
            }
            fos.write(data);

        }// end while
    }
}