package com.company.practice_4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class NewExecutorService implements ExecutorService {

    public ExecutorService threads;

    public NewExecutorService(int threads){
        this.threads = Executors.newFixedThreadPool(threads);
    }
    @Override
    public void shutdown() {
        threads.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return threads.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return threads.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return threads.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return threads.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return threads.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return threads.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return threads.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return threads.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return threads.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return threads.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return threads.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        threads.execute(command);
    }
}
