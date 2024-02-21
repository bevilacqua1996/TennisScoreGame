package org.bevilacqua1996;

import org.bevilacqua1996.logic.TennisScoreGame;
import org.bevilacqua1996.logic.impl.TennisScoreLogic;
import org.bevilacqua1996.utils.PropertiesSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.bevilacqua1996.utils.Constants.*;

public class TennisScoreTest {

    @Test
    public void testSimplePlayerAWins() {
        String input = "ABABAA";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(PLAYER_A_WINS, result);
    }

    @Test
    public void testSimplePlayerBWins() {
        String input = "ABABBB";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(PLAYER_B_WINS, result);
    }

    @Test
    public void testEasyGamePlayerBWins() {
        String input = "BABBB";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(PLAYER_B_WINS, result);
    }

    @Test
    public void testEasyGamePlayerAWins() {
        String input = "AAAA";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(PLAYER_A_WINS, result);
    }

    @Test
    public void testDeucePlayerBWins() {
        String input = "ABABABBB";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(PLAYER_B_WINS, result);
    }

    @Test
    public void testDoubleDeucePlayerAWins() {
        String input = "ABABABBAAA";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(PLAYER_A_WINS, result);
    }

    @Test
    public void testTripleDeucePlayerBWins() {
        String input = "ABABABBAABBB";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(PLAYER_B_WINS, result);
    }

    @Test
    public void testNoWinnerValidation() {
        String input = "ABABAB";

        TennisScoreGame tennisScoreLogic = new TennisScoreLogic();

        String result = tennisScoreLogic.play(input);

        Assertions.assertEquals(NO_WINNER_VALIDATION, result);
    }

}
