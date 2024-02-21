package org.bevilacqua1996.input.impl;

import org.bevilacqua1996.input.InputData;
import org.bevilacqua1996.logic.TennisScoreGame;
import org.bevilacqua1996.logic.impl.TennisScoreLogic;

public class SimpleInputString implements InputData {

    TennisScoreGame tennisScoreGame = new TennisScoreLogic();
    @Override
    public void process(String input) {
        tennisScoreGame.play(input);
    }
}
