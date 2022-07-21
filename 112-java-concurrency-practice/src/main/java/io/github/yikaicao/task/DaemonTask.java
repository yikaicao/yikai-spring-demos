package io.github.yikaicao.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaemonTask implements Runnable {

    @Override
    public void run() {
        log.info("currentThread={}", Thread.currentThread());
        Thread.currentThread().setDaemon(true);
    }
}
