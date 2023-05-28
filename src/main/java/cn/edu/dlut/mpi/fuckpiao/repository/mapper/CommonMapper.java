package cn.edu.dlut.mpi.fuckpiao.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface CommonMapper<T> extends BaseMapper<T> {

  int insertBatchSomeColumn(List<T> entityList);
}
