package org.bevilacqua1996.model;

import java.util.*;

public enum ScoresEnum {

    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    AD("AD");

    private final String scoreString;

    ScoresEnum(String scoreString) {
        this.scoreString = scoreString;
    }

    public String getScoreString() {
        return scoreString;
    }

    public static ListIterator<ScoresEnum> orderedScore() {
        return Arrays.asList(ZERO, FIFTEEN, THIRTY, FORTY, AD).listIterator();
    }

    public static List<String> orderedScoreList() {
        return Arrays.asList(ZERO.getScoreString(), FIFTEEN.getScoreString(), THIRTY.getScoreString(), FORTY.getScoreString(), AD.getScoreString());
    }
}
