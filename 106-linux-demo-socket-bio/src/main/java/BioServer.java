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
        do {
            System.out.println("waiting for connection");
            Socket clientSocket = serverSocket.accept();
            System.out.println("client connected");
            executor.submit(() -> {
                try {
                    handler(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } while (true);
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("ready to read");

        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read completed");
        if (read != -1) {
            System.out.println("received: " + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("hello, client".getBytes(StandardCharsets.UTF_8));
        clientSocket.getOutputStream().flush();
    }
}
