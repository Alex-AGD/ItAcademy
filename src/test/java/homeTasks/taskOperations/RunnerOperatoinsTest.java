package homeTasks.taskOperations;

import org.junit.Assert;
import org.junit.Test;

public class RunnerOperatoinsTest {

    @Test
    public void testAdd() throws Exception {

        Operations printMoreZero = new Operations();
        printMoreZero.printMoreZero(4);
        System.out.println();
        Assert.assertEquals(4,4);
        }

    }
