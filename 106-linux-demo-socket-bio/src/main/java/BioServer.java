import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    private static final ExecutorService executor = Executors.newFixedThreadPool(1200);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10200);
        while (true) {
            System.out.println("等待链接");
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端链接");
            executor.submit(() -> {
                try {
                    handler(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read");

        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完成");
        if (read != -1) {
            System.out.println("接收到的数据为" + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("你好，客户端".getBytes(StandardCharsets.UTF_8));
        clientSocket.getOutputStream().flush();
    }
}
