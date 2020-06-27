package cn.junhaox.vhrBack.utils;

import cn.junhaox.vhrBack.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/25 9:47
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
