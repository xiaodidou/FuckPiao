package cn.edu.dlut.mpi.fuckpiao.commons;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.function.Supplier;
import lombok.Data;

@Data
public class ResponseEntity<T> {

  private int code;
  private T result;

  public static <T> ResponseEntity<T> success(T result) {
    ResponseEntity<T> responseEntity = new ResponseEntity<>();
    responseEntity.setCode(200);
    responseEntity.setResult(result);
    return responseEntity;
  }

  public static ResponseEntity<Map<String, Boolean>> of(Supplier<Boolean> supplier) {
    Boolean result = supplier.get();
    ResponseEntity<Map<String, Boolean>> responseEntity = new ResponseEntity<>();
    responseEntity.setCode(200);
    responseEntity.setResult(ImmutableMap.of("Success", result));
    return responseEntity;
  }
}
