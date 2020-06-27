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
        Department dept = new Department();
        dept.setId(id);
        departmentService.deleteDeptById(dept);
        if (dept.getResult() == 1) {
            return RespBeen.ok("删除成功");
        } else if (dept.getResult() == -1) {
            return RespBeen.error("该部门下有员工，删除失败");
        } else if (dept.getResult() == -2) {
            return RespBeen.error("该部门下有子部门，删除失败");
        }
        return RespBeen.ok("删除失败");
    }

    @PostMapping("/")
    public RespBeen addDept(@RequestBody Department dept) {
        departmentService.addDept(dept);
        if (dept.getResult() == 1) {
            return RespBeen.ok("添加成功", dept);
        }
        return RespBeen.error("添加失败");
    }
}
