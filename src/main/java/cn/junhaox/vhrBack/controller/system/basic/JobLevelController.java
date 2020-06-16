package cn.junhaox.vhrBack.controller.system.basic;

import cn.junhaox.vhrBack.model.JobLevel;
import cn.junhaox.vhrBack.model.RespBeen;
import cn.junhaox.vhrBack.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/14 9:41
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBeen addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBeen.ok("添加成功!");
        }
        return RespBeen.error("添加失败!");
    }

    @PutMapping("/")
    public RespBeen updateJobLevelById(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return RespBeen.ok("更新成功!");
        }
        return RespBeen.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBeen deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBeen.ok("删除成功!");
        }
        return RespBeen.error("删除失败!");
    }

    @DeleteMapping("/")
    public RespBeen deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return RespBeen.ok("删除成功!");
        }
        return RespBeen.error("删除失败!");
    }
}
