package dev.mzcy.cloud.node.terminal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.jline.jansi.Ansi;

@Getter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public enum Color {

    HIGHLIGHTER(255, 187, 0),
    DEFAULT(181, 181, 181),
    DARK(60, 60, 60),
    ERROR(255, 0, 0);

    final String ansi;

    private static final Color[] VALUES = values();

    Color(int r, int g, int b) {
        this.ansi = Ansi.ansi().a(Ansi.Attribute.RESET).fgRgb(r, g, b).toString();
    }

    public static String translate(String output) {
        for (Color color : VALUES) {
            output = output.replace("&" + color.ordinal(), color.getAnsi());
        }
        return output;
    }
}
