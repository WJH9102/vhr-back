package cn.junhaox.vhrBack.controller.system.basic;

import cn.junhaox.vhrBack.model.Position;
import cn.junhaox.vhrBack.model.RespBeen;
import cn.junhaox.vhrBack.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/6 10:01
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBeen addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBeen.ok("添加成功!");
        }
        return RespBeen.error("添加失败!");
    }

    @PutMapping("/")
    public RespBeen updatePositions(@RequestBody Position position) {
        if (positionService.updatePositions(position) == 1) {
            return RespBeen.ok("更新成功!");
        }
        return RespBeen.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBeen deletePositionById(@PathVariable Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return RespBeen.ok("删除成功!");
        }
        return RespBeen.error("删除失败!");
    }
}
