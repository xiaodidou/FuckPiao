package cn.edu.dlut.mpi.fuckpiao.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

  @Bean
  public ThreadPoolTaskExecutor parseInvoiceThreadPool() {
    ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
    int processNum = Runtime.getRuntime().availableProcessors();
    int corePoolSize = (int) (processNum / (1 - 0.2));
    int maxPoolSize = (int) (processNum / (1 - 0.5));
    ThreadFactory threadFactory = new ThreadFactoryBuilder()
        .setNameFormat("parseInvoice-%d")
        .build();
    threadPool.setCorePoolSize(corePoolSize);
    threadPool.setMaxPoolSize(maxPoolSize);
    threadPool.setQueueCapacity(1000);
    threadPool.setThreadNamePrefix("parseInvoice");
    threadPool.setThreadFactory(threadFactory);
    return threadPool;
  }
}
