package dev.mzcy.cloud.node.terminal;


import dev.mzcy.cloud.node.CloudInstance;

public final class Jline3TerminalRunner extends Thread {

    private Jline3Terminal terminal;

    public Jline3TerminalRunner(Jline3Terminal terminal) {
        this.terminal = terminal;

        this.setDaemon(false);
        this.setName("Jline3TerminalRunner");
        this.setPriority(1);

        this.start();
    }

    @Override
    public void run() {
        String line;
        while ((line = terminal.getLineReader().readLine("cloud > ")) != null) {
            ((CloudInstance) CloudInstance.getInstance()).getCommandProvider().call(line.split(" "));
        }
    }
}
