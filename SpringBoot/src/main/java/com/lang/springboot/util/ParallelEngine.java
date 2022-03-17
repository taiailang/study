package com.lang.springboot.util;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 浪浪
 * @date 2022/2/18
 */

@Slf4j
public class ParallelEngine {

    /**
     * 机器核心数相关
     */
    private static int corePoolSize = 6;

    /**
     * 最大允许的线程数
     */
    private static int maximumPoolSize = 6;

    /**
     * 任务队列的size
     */
    private static int blockingQueueSize = 1000;

    /**
     * 核心线程存活时间
     */
    private static int keepAliveTime = 10;

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
            keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<>(blockingQueueSize), new ThreadFactoryBuilder()
            .setNameFormat("parallel-engine-%d").build());

    public static ScheduledThreadPoolExecutor executor2 = new ScheduledThreadPoolExecutor(2, new ThreadFactoryBuilder()
            .setNameFormat("parallel-engine-%d").build());

    public static void execute(Runnable task) {
        execute(task, 0);
    }

    /**
     * 异步任务
     * @param task  任务
     * @param delay 秒
     */
    public static void executeScheduledTask(Runnable task, int delay) {
        executor2.scheduleWithFixedDelay(task,2, delay, TimeUnit.SECONDS);
    }

    public static void execute(Runnable task, int delay) {
        if (task == null) {
            return;
        }
        if (delay > 0) {
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (Exception e) {
                log.error("execute interrupt error", e);
            }
        }
        executor.submit(task);
    }

    public static <T> List<T> concurrentExecute(List<Callable<T>> tasks) {
        if ((tasks == null) || (tasks.size() == 0)) {
            return Lists.newArrayList();
        }
        return concurrentExecute(-1L, null, tasks);
    }

    public static <T> List<T> concurrentExecute(long timeout, TimeUnit unit, List<Callable<T>> tasks) {
        if (CollectionUtils.isEmpty(tasks)) {
            return Lists.newArrayList();
        }
        List<T> result = Lists.newArrayList();
        try {
            List<Future<T>> futures;
            if (timeout > 0L) {
                futures = executor.invokeAll(tasks, timeout, unit);
            } else {
                futures = executor.invokeAll(tasks);
            }
            int activeThreadCount = executor.getActiveCount();
            if (activeThreadCount > 9) {
                log.info("ParallelEngine active thread count : " + activeThreadCount);
            }
            for (Future<T> future : futures) {
                T t = null;
                try {
                    // get等待返回结果
                    t = future.get();
                } catch (CancellationException e) {
                    if (timeout > 0L) {
                        log.error("concurrentExecute some task timeout!");
                    }
                } catch (Exception tt) {
                    log.error("future.get() Exception ", tt);
                }
                result.add(t);
            }
        } catch (Exception e) {
            log.error("executor.invokeAll() Exception", e);
        }
        return result;
    }
}
