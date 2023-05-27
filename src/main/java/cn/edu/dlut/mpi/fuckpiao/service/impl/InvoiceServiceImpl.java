package cn.edu.dlut.mpi.fuckpiao.service.impl;

import cn.edu.dlut.mpi.fuckpiao.service.InvoiceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class InvoiceServiceImpl implements InvoiceService {

  private final ThreadPoolTaskExecutor threadPoolExecutor;

  public InvoiceServiceImpl(
      @Qualifier(value = "parseInvoiceThreadPool") ThreadPoolTaskExecutor threadPoolExecutor) {
    this.threadPoolExecutor = threadPoolExecutor;
  }

  @Override
  public void parseInvoicesFromPdf(MultipartFile[] files) {
  }

}
