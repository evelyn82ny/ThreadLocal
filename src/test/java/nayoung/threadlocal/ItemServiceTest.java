package nayoung.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ItemServiceTest {

    private ItemService itemService = new ItemService();

    @Test
    void concurrencyTest() {
        Runnable userA = () -> itemService.changePrice(1000L);
        Runnable userB = () -> itemService.changePrice(2000L);

        Thread threadA = new Thread(userA);
        threadA.setName("thread_A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread_B");

        threadA.start();
        sleep(100); // no concurrency issues

        threadB.start();

        sleep(3000);
    }

    private void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}