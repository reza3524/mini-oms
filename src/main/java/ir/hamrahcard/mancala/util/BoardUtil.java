package ir.hamrahcard.mancala.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BoardUtil {

    public String getTemplate() {
        return """
                             player 2
                    |%d|,|%d|,|%d|,|%d|,|%d|,|%d|
                (%d)                              (%d)
                    |%d|,|%d|,|%d|,|%d|,|%d|,|%d|
                              player 1
                """;
    }
}
