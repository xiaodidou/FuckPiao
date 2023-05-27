package cn.edu.dlut.mpi.fuckpiao.controller;

import cn.edu.dlut.mpi.fuckpiao.commons.ResponseEntity;
import cn.edu.dlut.mpi.fuckpiao.service.InvoiceService;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class InvoiceController {


  private InvoiceService invoiceService;

  /**
   * 保存上传的pdf文件，并存储发票信息
   *
   * @param files 发票pdf文件
   * @return 保存结果
   */
  @PostMapping("/upload")
  public ResponseEntity<Map<String, Boolean>> saveInvoice(
      @RequestParam(name = "files") MultipartFile[] files) {
    invoiceService.parseInvoicesFromPdf(files);
    return ResponseEntity.of(() -> true);
  }

}
