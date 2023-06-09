package Tests;

import com.isep.Bowling.Game;
import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingGameTest {
    // check that a game of all zeros scores zero
    @Test
    public void testGutterGame() {
        Game g = new Game();
        for (int i = 0; i < 20; i++)
            g.roll(0);
        assertEquals(0, g.score());
    }

    // check that a game of all ones scores 20
    @Test
    public void testAllOnes() {
        Game g = new Game();
        for (int i = 0; i < 20; i++)
            g.roll(1);
        assertEquals(20, g.score());
    }

    // check that a game of one spare followed by three pins, followed by all misses scores 16
    @Test
    public void testOneSpare() {
        Game g = new Game();
        g.roll(5);
        g.roll(5); // spare
        for (int i = 0; i < 17; i++)
            g.roll(0);
        assertEquals(16, g.score());
    }

    // check that a game of one strike followed by three and then four pins, followed by all misses scores 24
    @Test
    public void testOneStrike() {
        Game g = new Game();
        g.roll(10); // strike
        g.roll(3);
        g.roll(4);

        assertEquals(24, g.score());
    }

    @Test
    public void testPerfectGame() {
        Game g = new Game();
        for (int i = 0; i < 10; i++){
            g.roll(10);
        }
        assertEquals(300, g.score());
    }

    @Test
    public void testRandomGame() {
        Game g = new Game();
        g.roll(9);
        g.roll(1);
        g.roll(5);
        g.roll(5);
        g.roll(7);
        g.roll(2);
        g.roll(10);
        g.roll(10);
        g.roll(10);
        g.roll(2);
        g.roll(8);
        g.roll(6);
        g.roll(2);
        g.roll(7);
        g.roll(3);
        g.roll(10);
        assertEquals(167, g.score());
    }

}
