package api.worker;

import api.impl.AbstractApiTaskImpl;
import api.impl.handlers.HandlerResultImpl;
import api.interfaces.IApiTask;
import api.utils.CacheResult;
import groovy.transform.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.*;


public class TaskManager {
    volatile static TaskManager instance = null;
    @Autowired
    CacheResult cacheResult;
    @Synchronized
    @Bean(name="taskManager")
    static TaskManager get(){
        if(instance == null)
            instance = new TaskManager();
        return instance;
    }

    @Bean(name="threadPool")
    static ThreadPoolExecutor threadPoolExecutor(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,10,0, TimeUnit.SECONDS,new SynchronousQueue<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {

            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
            }
        };
        return threadPoolExecutor;
    }
    private final ConcurrentHashMap<String, IApiTask> currentWorkers = new ConcurrentHashMap<>();

    public void addTask(AbstractApiTaskImpl apiTask)throws Exception{
        try {
            threadPoolExecutor().execute(apiTask);
        }catch (RejectedExecutionException e){
            throw new Exception("Очередь переполненна,повторите позже!");
        }

    }


}
