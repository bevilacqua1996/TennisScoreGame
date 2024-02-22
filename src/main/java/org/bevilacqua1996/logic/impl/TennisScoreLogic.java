package org.bevilacqua1996.logic.impl;

import org.bevilacqua1996.logic.TennisScoreGame;
import org.bevilacqua1996.model.OutputEnum;
import org.bevilacqua1996.model.ScoresEnum;
import org.bevilacqua1996.output.OutputScores;
import org.bevilacqua1996.utils.PropertiesSingleton;

import java.util.List;
import java.util.ListIterator;

import static org.bevilacqua1996.utils.Constants.*;

public class TennisScoreLogic implements TennisScoreGame {

    public TennisScoreLogic() {
        String output = PropertiesSingleton.getInstance().getProperty("architecture.output");
        outputScores = OutputEnum.ofOutputString(output);
    }
    OutputScores outputScores;

    public String play(String input) {
        ListIterator<ScoresEnum> scoresPlayerA = ScoresEnum.orderedScore();
        ListIterator<ScoresEnum> scoresPlayerB = ScoresEnum.orderedScore();
        List<String> scoresList = ScoresEnum.orderedScoreList();

        StringBuilder finalResult = new StringBuilder();

        scoresPlayerA.next();
        scoresPlayerB.next();

        boolean hasWinner = false;

        for(int i=0; i<input.length(); i++) {
            if(hasWinner) {
                outputScores.print(GAME_ALREADY_OVER);
                break;
            }
            switch (input.charAt(i)) {
                case 'A' -> {
                    if(isWinnerBall(scoresPlayerA, scoresPlayerB)) {
                        finalResult.append(PLAYER_A_WINS);
                        outputScores.print(PLAYER_A_WINS);
                        hasWinner = true;
                        break;
                    }
                    outputScores.print("Player A:" + scoresList.get(scoresPlayerA.nextIndex()-1) + " / Player B:" + scoresList.get(scoresPlayerB.nextIndex()-1));
                }
                case 'B' -> {
                    if(isWinnerBall(scoresPlayerB, scoresPlayerA)) {
                        finalResult.append(PLAYER_B_WINS);
                        outputScores.print(PLAYER_B_WINS);
                        hasWinner = true;
                        break;
                    }
                    outputScores.print("Player A:" + scoresList.get(scoresPlayerA.nextIndex()-1) + " / Player B:" + scoresList.get(scoresPlayerB.nextIndex()-1));
                }
            }
        }

        outputScores.print("");

        if(!hasWinner) {
            finalResult.append(NO_WINNER_VALIDATION);
            outputScores.print(NO_WINNER_VALIDATION);
            outputScores.print("");
            return  finalResult.toString();
        }

        return finalResult.toString();

    }

    private boolean isWinnerBall(ListIterator<ScoresEnum> playerWhichScores, ListIterator<ScoresEnum> otherPlayer) {
        if(!playerWhichScores.hasNext()) {
            return true;
        }

        // Compute point
        ScoresEnum currentlyScore = playerWhichScores.next();

        // Check Advantage from another player and deuce
        if(!otherPlayer.hasNext()) {
            playerWhichScores.previous();
            otherPlayer.previous();
            return false;
        }

        // Check deuce and now advantage or winning ball
        if(currentlyScore.equals(ScoresEnum.AD)) {
            ScoresEnum otherPlayerNextPoint = otherPlayer.next();
            if(!otherPlayerNextPoint.equals(ScoresEnum.AD)) {
                return true;
            } else {
                otherPlayer.previous();
            }
        }

        return false;
    }
}
