package org.bevilacqua1996.input.impl;

import org.bevilacqua1996.input.InputData;
import org.bevilacqua1996.logic.TennisScoreGame;
import org.bevilacqua1996.logic.impl.TennisScoreLogic;
import org.bevilacqua1996.model.OutputEnum;
import org.bevilacqua1996.output.OutputScores;
import org.bevilacqua1996.utils.Constants;
import org.bevilacqua1996.utils.PropertiesSingleton;

public class SimpleInputString implements InputData {

    TennisScoreGame tennisScoreGame = new TennisScoreLogic();

    public SimpleInputString() {
        String output = PropertiesSingleton.getInstance().getProperty("architecture.output");
        outputScores = OutputEnum.ofOutputString(output);
    }

    OutputScores outputScores;

    @Override
    public void process(String input) {
        if(isValid(input)) {
            tennisScoreGame.play(input);
        } else {
            outputScores.print(Constants.NOT_A_VALID_INPUT);
            outputScores.print("");
        }

    }

    private boolean isValid(String input) {
        return input.chars().noneMatch((charInput) -> charInput != 'A' && charInput != 'B');
    }
}
