package cn.edu.dlut.mpi.fuckpiao.service;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

  String path = "./files";

  @Test
  public void test() {
//    System.out.println(Arrays.toString(FileUtil.ls(path)));
    String date = DateUtil.format(DateUtil.date(), "yyyy/MM/dd");
    System.out.println(date);
  }

}
