import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FindErrorGameTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void gameCreationTest() {
        Assert.assertNotNull(game);
    }

    @Test
    public void HasNextTaskTest() {
        boolean answer;
        answer = game.hasNextTask();
        Assert.assertNotNull(answer);
    }

    @Test
    public void SetTaskTest() {
        game.clearTasks();
        Task setTask = new Task(new String[] {"int main() {}"});
        game.setTask(setTask);
        Task getTask = game.getNextTask();
        Assert.assertEquals(setTask, getTask);
    }

    @Test
    public void SetErrorLineIndexes() {
        Task task = new Task(new String[] {"int main() {}"});
        ArrayList<Integer> errorLineIndexes = new ArrayList<Integer>();
        errorLineIndexes.add(1);
        task.setErrorLineIndexes(errorLineIndexes);
        ArrayList<Integer> getErrorLineIndexes = task.getErrorLineIndexes();
        Assert.assertArrayEquals(errorLineIndexes.toArray(), getErrorLineIndexes.toArray());
    }

    @Test
    public void CheckAnswersTest() {
        game.clearTasks();
        Task task = new Task(new String[] {"int main() {"});
        ArrayList<Integer> errorLineIndexes = new ArrayList<Integer>();
        errorLineIndexes.add(1);
        task.setErrorLineIndexes(errorLineIndexes);
        game.setTask(task);
        game.getNextTask();

        ArrayList<Integer> answers = new ArrayList<Integer>();
        answers.add(1);
        boolean result = game.checkAnswers(answers);
        Assert.assertTrue(result);
    }

    @Test
    public void OpenFilesTest() throws FileNotFoundException {
        boolean res = game.fillTasks();
        Assert.assertTrue(res);
    }
}
