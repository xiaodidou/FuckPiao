package cn.edu.dlut.mpi.fuckpiao.repository.po;

import cn.edu.dlut.mpi.fuckpiao.domain.Invoice;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

@Data
@TableName("invoice")
public class InvoicePO {

  @TableId(type = IdType.AUTO)
  private int id;
  private String code;
  private DateTime issueDate;
  private String buyerName;
  private String buyerTaxCode;
  private BigDecimal taxTotalAmount;
  private DateTime createTime;

  public static InvoicePO fromInvoice(Invoice invoice) {
    InvoicePO po = new InvoicePO();
    po.setCode(invoice.getCode());
    po.setIssueDate(invoice.getDate());
    po.setBuyerName(invoice.getBuyerName());
    po.setBuyerTaxCode(invoice.getBuyerCode());
    po.setTaxTotalAmount(invoice.getTotalAmount());
    po.setCreateTime(DateTime.now());
    return po;
  }
}
