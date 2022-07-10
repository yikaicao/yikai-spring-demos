import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NioServer {

    final static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverScoektChannel = ServerSocketChannel.open();
        serverScoektChannel.socket().bind(new InetSocketAddress(10201));
        serverScoektChannel.configureBlocking(false);
        System.out.println("server started successfully");

        while (true) {
            System.out.println("waiting");
            SocketChannel socketChannel = serverScoektChannel.accept();
            if (socketChannel != null) {
                System.out.println("connection established");
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()) {
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = sc.read(byteBuffer);
                if (len > 0) {
                    System.out.println("received message: " + new String(byteBuffer.array()));
                } else if (len == -1) {
                    iterator.remove();
                    System.out.println("client disconnected");

                }

            }
        }
    }
}
