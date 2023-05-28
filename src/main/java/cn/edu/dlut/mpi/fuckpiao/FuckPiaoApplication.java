package cn.edu.dlut.mpi.fuckpiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengyu
 */
@SpringBootApplication
@MapperScan("cn.edu.dlut.mpi.fuckpiao.repository.mapper")
public class FuckPiaoApplication {

  public static void main(String[] args) {
    SpringApplication.run(FuckPiaoApplication.class, args);
  }

}
