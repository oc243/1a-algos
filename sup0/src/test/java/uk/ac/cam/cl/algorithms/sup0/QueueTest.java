package uk.ac.cam.cl.algorithms.sup0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QueueTest extends junit.framework.TestCase {

    Queue queue;

    @Test
    public void emptyTest() {

    }


    public QueueTest(Queue queue) {
        this.queue = queue;
    }

    @Parameterized.Parameters
    public static Collection<Queue[]> instancesToTest() {
        Queue[][] queues = {{new TwoStackQueue()}};
        return Arrays.asList(queues);
    }

}
