package org.bevilacqua1996.logic.impl;

import org.bevilacqua1996.logic.TennisScoreGame;
import org.bevilacqua1996.model.ScoresEnum;
import org.bevilacqua1996.print.PrintScores;
import org.bevilacqua1996.print.impl.PrintSysout;

import java.util.List;
import java.util.ListIterator;

import static org.bevilacqua1996.utils.Constants.*;

public class TennisScoreLogic implements TennisScoreGame {

    PrintScores printScores = new PrintSysout();

    ListIterator<ScoresEnum> scoresPlayerA = ScoresEnum.orderedScore();
    ListIterator<ScoresEnum> scoresPlayerB = ScoresEnum.orderedScore();

    List<String> scoresList = ScoresEnum.orderedScoreList();

    public String play(String input) {

        StringBuilder finalResult = new StringBuilder();

        scoresPlayerA.next();
        scoresPlayerB.next();

        boolean hasWinner = false;

        for(int i=0; i<input.length(); i++) {
            switch (input.charAt(i)) {
                case 'A' -> {
                    if(calculatePoints(scoresPlayerA, scoresPlayerB)) {
                        finalResult.append(PLAYER_A_WINS);
                        printScores.print(PLAYER_A_WINS);
                        hasWinner = true;
                        break;
                    }
                    printScores.print("Player A:" + scoresList.get(scoresPlayerA.nextIndex()-1) + " / Player B:" + scoresList.get(scoresPlayerB.nextIndex()-1));
                }
                case 'B' -> {
                    if(calculatePoints(scoresPlayerB, scoresPlayerA)) {
                        finalResult.append(PLAYER_B_WINS);
                        printScores.print(PLAYER_B_WINS);
                        hasWinner = true;
                        break;
                    }
                    printScores.print("Player A:" + scoresList.get(scoresPlayerA.nextIndex()-1) + " / Player B:" + scoresList.get(scoresPlayerB.nextIndex()-1));
                }
            }
        }

        if(!hasWinner) {
            finalResult.append(NO_WINNER_VALIDATION);
            return  finalResult.toString();
        }

        return finalResult.toString();

    }

    private boolean calculatePoints(ListIterator<ScoresEnum> playerWhichScores, ListIterator<ScoresEnum> otherPlayer) {
        if(!playerWhichScores.hasNext()) {
            return true;
        }

        ScoresEnum currentlyScore = playerWhichScores.next();

        if(!otherPlayer.hasNext()) {
            playerWhichScores.previous();
            otherPlayer.previous();
            return false;
        }

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