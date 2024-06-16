package dev.mzcy.cloud.node.terminal;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.nio.charset.StandardCharsets;

@Getter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public final class Jline3Terminal {

    Terminal terminal;
    LineReader lineReader;
    Jline3TerminalRunner jline3TerminalRunner;

    @SneakyThrows
    public Jline3Terminal() {
        this.terminal = TerminalBuilder.builder()
                .system(true)
                .dumb(true)
                .streams(System.in, System.out)
                .encoding(StandardCharsets.UTF_8)
                .build();
        this.lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .option(LineReader.Option.CASE_INSENSITIVE, true)
                .option(LineReader.Option.DISABLE_EVENT_EXPANSION, true)
                .build();

        this.jline3TerminalRunner = new Jline3TerminalRunner(this);

    }

    @SneakyThrows
    public void close() {
        this.jline3TerminalRunner.interrupt();
        this.terminal.close();
    }

}
