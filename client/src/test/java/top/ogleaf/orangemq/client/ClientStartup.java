package top.ogleaf.orangemq.client;

import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import top.ogleaf.orangemq.client.handler.MyClientHandler;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ClientStartup {
    public static void main(String[] args) {
        new MqClient();
    }
}
