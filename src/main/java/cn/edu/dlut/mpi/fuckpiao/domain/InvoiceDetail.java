package cn.edu.dlut.mpi.fuckpiao.domain;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class InvoiceDetail {

  private String name;
  private String model;
  private String unit;
  private BigDecimal count;
  private BigDecimal price;
  private BigDecimal amount;
  private BigDecimal taxRate;
  private BigDecimal taxAmount;
}
