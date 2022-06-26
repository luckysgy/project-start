package com.projectstart.start.config;

import com.concise.component.core.thread.ThreadPoolProperties;
import com.concise.component.core.thread.TtlThreadPoolTaskExecutor;
import com.concise.component.core.thread.TtlThreadPoolTaskScheduler;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.Resource;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig implements SchedulingConfigurer {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ThreadPoolProperties threadPoolProperties;

    /**
     * 定时任务使用的线程池
     */
    @Bean(destroyMethod = "shutdown", name = "myTaskScheduler")
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new TtlThreadPoolTaskScheduler();
        scheduler.setPoolSize(threadPoolProperties.getCorePoolSize());
        scheduler.setThreadNamePrefix("task-");
        scheduler.setAwaitTerminationSeconds(600);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }

    /**
     * 异步任务执行线程池
     * <code>
     *     @Resource
     *     private ThreadPoolTaskExecutor myThreadPoolTaskExecutor;
     * </code>
     */
    @Bean(name = "myThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor myThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new TtlThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());
        // 线程队列最大线程数
        executor.setQueueCapacity(threadPoolProperties.getQueueCapacity());
        // 线程池中线程最大空闲存活时间
        executor.setKeepAliveSeconds(threadPoolProperties.getKeepAliveSeconds());
        // 线程池最大线程数
        executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
        executor.setThreadNamePrefix("taskExecutor-");
        // 核心线程是否允许超时，默认:false
        executor.setAllowCoreThreadTimeOut(false);
        /*
         * 拒绝策略，默认是AbortPolicy
         * AbortPolicy：丢弃任务并抛出RejectedExecutionException异常
         * DiscardPolicy：丢弃任务但不抛出异常
         * DiscardOldestPolicy：丢弃最旧的处理程序，然后重试，如果执行器关闭，这时丢弃任务
         * CallerRunsPolicy：执行器执行任务失败，则在策略回调方法中执行任务，如果执行器关闭，这时丢弃任务
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // IOC容器关闭时是否阻塞等待剩余的任务执行完成，默认:false（true则必须设置setAwaitTerminationSeconds）
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 阻塞IOC容器关闭的时间
        executor.setAwaitTerminationSeconds(60);

        executor.initialize();
        return executor;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler taskScheduler = taskScheduler();
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
    }

    /**
     * 执行周期性或定时任务
     */
    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(threadPoolProperties.getCorePoolSize(),
                new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build(),
                new ThreadPoolExecutor.CallerRunsPolicy()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t)
            {
                super.afterExecute(r, t);
                Threads.printException(r, t);
            }
        };
    }
}
