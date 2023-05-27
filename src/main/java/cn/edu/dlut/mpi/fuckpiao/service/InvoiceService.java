package cn.edu.dlut.mpi.fuckpiao.service;

import org.springframework.web.multipart.MultipartFile;

public interface InvoiceService {

  void parseInvoicesFromPdf(MultipartFile[] files);

}
