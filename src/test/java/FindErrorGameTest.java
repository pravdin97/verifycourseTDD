import org.junit.Assert;
import org.junit.Test;

public class FindErrorGameTest {
    @Test
    public void gameCreationTest() {
        Game game = new Game();
        Assert.assertNotNull(game);
    }

    @Test
    public void getNextTaskTest() {
        Game game = new Game();
        Assert.assertNotNull(game.getNextTask());
    }

    @Test
    public void TaskGetTextTest() {
        Game game = new Game();
        String [] text = game.getNextTask().getText();
        Assert.assertNotNull(text);
    }
}
