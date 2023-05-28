package cn.edu.dlut.mpi.fuckpiao.service.impl;

import cn.edu.dlut.mpi.fuckpiao.domain.Invoice;
import cn.edu.dlut.mpi.fuckpiao.repository.InvoiceRepository;
import cn.edu.dlut.mpi.fuckpiao.service.InvoiceService;
import cn.edu.dlut.mpi.fuckpiao.util.PdfInvoiceExtractor;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import java.io.File;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

  private final ThreadPoolTaskExecutor threadPool;
  private final String saveDir;
  private final InvoiceRepository invoiceRepository;

  public InvoiceServiceImpl(
      @Qualifier(value = "parseInvoiceThreadPool") ThreadPoolTaskExecutor threadPool,
      @Value("${file.save-dir}") String saveDir,
      InvoiceRepository invoiceRepository) {
    this.threadPool = threadPool;
    this.saveDir = saveDir;
    this.invoiceRepository = invoiceRepository;
  }

  @Override
  public void parseInvoicesFromPdf(MultipartFile[] files) {
    String date = DateUtil.format(DateUtil.date(), "yyyy_MM_dd");
    String path = FileUtil.getAbsolutePath(saveDir + "/" + date);
    if (!FileUtil.exist(saveDir)) {
      FileUtil.mkdir(saveDir);
    }
    Arrays.stream(FileUtil.ls(saveDir)).filter(File::isDirectory)
        .map(File::getName).filter(date::equals)
        .findFirst().orElseGet(() -> {
          FileUtil.mkdir(path);
          return "ok";
        });
    Arrays.stream(files).forEach(file -> {
      try {
        String name = file.getOriginalFilename();
        File dest = new File(path, name);
        FileUtils.writeByteArrayToFile(dest, file.getBytes());
        Invoice invoice = PdfInvoiceExtractor.extract(path, name);
        String code = invoice.getCode();
        FileUtil.rename(dest, code + ".pdf", true);
        invoiceRepository.insert(invoice);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    });
  }

}

