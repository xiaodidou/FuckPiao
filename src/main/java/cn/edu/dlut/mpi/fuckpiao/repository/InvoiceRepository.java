package cn.edu.dlut.mpi.fuckpiao.repository;

import cn.edu.dlut.mpi.fuckpiao.domain.Invoice;
import java.util.List;

public interface InvoiceRepository {

  void insertBatch(List<Invoice> invoices);

  void insert(Invoice invoice);
}
