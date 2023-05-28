package cn.edu.dlut.mpi.fuckpiao.repository.impl;

import cn.edu.dlut.mpi.fuckpiao.domain.Invoice;
import cn.edu.dlut.mpi.fuckpiao.repository.InvoiceRepository;
import cn.edu.dlut.mpi.fuckpiao.repository.mapper.InvoiceMapper;
import cn.edu.dlut.mpi.fuckpiao.repository.po.InvoicePO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {

  private InvoiceMapper mapper;

  public InvoiceRepositoryImpl(InvoiceMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public void insertBatch(List<Invoice> invoices) {
    List<InvoicePO> pos = invoices.stream()
        .map(InvoicePO::fromInvoice)
        .collect(Collectors.toList());
    mapper.insertBatchSomeColumn(pos);
  }

  @Override
  public void insert(Invoice invoice) {
    InvoicePO po = InvoicePO.fromInvoice(invoice);
    QueryWrapper<InvoicePO> wrapper = new QueryWrapper<InvoicePO>().eq("code", invoice.getCode());
    if (!mapper.exists(wrapper)) {
      mapper.insert(po);
    }
  }
}
