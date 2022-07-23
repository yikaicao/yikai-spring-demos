import io.github.yikaicao.task.AtomicIncrementTask;
import io.github.yikaicao.task.DaemonTask;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class PracticeMain {

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        log.info("main started");
        submitDaemonTask();

    }

    private static void submitDaemonTask() {
        executor.submit(new DaemonTask());
    }

    private static void atomicIncrement() {
        executor.submit(new AtomicIncrementTask());
    }

}
