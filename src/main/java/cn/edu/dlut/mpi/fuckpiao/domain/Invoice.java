package cn.edu.dlut.mpi.fuckpiao.domain;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class Invoice {

  private String title;
  private String machineNumber;
  //发票代码
  private String code;
  //发票号码
  private String number;
  private DateTime date;
  private String checksum;
  private String buyerName;
  private String buyerCode;
  private String buyerAddress;
  private String buyerAccount;
  private String password;
  private BigDecimal amount;
  private BigDecimal taxAmount;
  private String totalAmountString;
  private BigDecimal totalAmount;
  private String sellerName;
  private String sellerCode;
  private String sellerAddress;
  private String sellerAccount;
  private String payee;
  private String reviewer;
  private String drawer;
  private String type;
  private List<InvoiceDetail> detailList;

  public void setDate(String date) {
    this.date = DateUtil.parse(date, "yyyy年MM月dd日");

  }
}
