package cn.junhaox.vhrBack.controller.system.basic;

import cn.junhaox.vhrBack.model.Department;
import cn.junhaox.vhrBack.model.RespBeen;
import cn.junhaox.vhrBack.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/16 21:59
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments(-1);
    }

    @DeleteMapping("/{id}")
    public RespBeen deleteDeptById(@PathVariable Integer id) {
        return RespBeen.ok("删除成功");
    }

    @DeleteMapping("/")
    public RespBeen addDept(@RequestBody Department dept) {
        return RespBeen.ok("删除成功");
    }
}
