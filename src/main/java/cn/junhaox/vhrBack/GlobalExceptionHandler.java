package cn.junhaox.vhrBack;

import cn.junhaox.vhrBack.model.RespBeen;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/13 10:50
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBeen sqlException(SQLException e) {
        if (e instanceof MySQLIntegrityConstraintViolationException) {
            return RespBeen.error("该数据有关联数据，操作失败");
        }
        return RespBeen.error("数据库异常，操作失败");
    }
}
