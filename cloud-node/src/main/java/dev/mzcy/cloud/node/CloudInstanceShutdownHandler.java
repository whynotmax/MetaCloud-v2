package dev.mzcy.cloud.node;

public class CloudInstanceShutdownHandler {

    public static void run() {

        CloudInstance.getInstance().getTerminal().close();

    }

}
