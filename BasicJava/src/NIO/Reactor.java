package NIO;

/**
 * Created by ballontt on 2017/9/3.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import java.util.Set;


public class Reactor implements Runnable
{

    final Selector selector;
    final ServerSocketChannel serverSocket;

    public Reactor(String ip, int port) throws IOException
    {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                System.out.println("selector is waitting  event....");
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                if (keys.size() == 0)
                {
                    System.out.println("nothing happened");
                    continue;
                }

                for (SelectionKey key : keys)
                {
                    if (key.isAcceptable())
                    {
                        System.out.println("Acceptable event happened");
                    }
                    else if (key.isReadable())
                    {
                        System.out.println("Readable event happened");
                    }
                    else if (key.isWritable())
                    {
                        System.out.println("Writeable event happened");
                    }
                    else
                    {
                        System.out.println("others event happened");
                    }
                    dispatch((SelectionKey) key);
                }
                keys.clear();
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    void dispatch(SelectionKey k)
    {
        Runnable r = (Runnable) (k.attachment());
        if (r != null)
        {
            r.run();
        }
    }

    public class Acceptor implements Runnable
    {
        public synchronized void run()
        {
            try
            {
                SocketChannel c = serverSocket.accept();
                System.out.println("got a new connection from:  " + c.socket().toString());
                if (c != null)
                {
                    new Handler(selector, c);
                }
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
