package cn.junhaox.vhrBack.service;

import cn.junhaox.vhrBack.mapper.DepartmentMapper;
import cn.junhaox.vhrBack.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/16 22:02
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments(Integer pid) {
        return departmentMapper.getAllDepartments(pid);
    }

    public void addDept(Department dept) {
        dept.setEnabled(true);
        departmentMapper.addDept(dept);
    }

    public void deleteDeptById(Department dept) {
        departmentMapper.deleteDeptById(dept);
    }
}
