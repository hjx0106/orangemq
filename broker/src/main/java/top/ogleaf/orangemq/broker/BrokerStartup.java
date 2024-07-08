package top.ogleaf.orangemq.broker;

public class BrokerStartup {
    public static void main(String[] args) {
        BrokerServer brokerServer = new BrokerServer();
        brokerServer.start();
    }
}
