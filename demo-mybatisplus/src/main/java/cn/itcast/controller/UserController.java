package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private IUserService userService;

    @PostMapping("/insert")
    public String insertUser(@RequestBody User user){
        boolean flag = userService.insertUser(user);
        return flag? "插入成功":"失败";
    }

    @GetMapping("/list")
    public IPage getList(@RequestParam("name") String name){
        return userService.getList(name);
    }

    @PostMapping("/update")
    public String updateData(@RequestBody User user){
        LambdaUpdateChainWrapper<User> lambdaUpdate = userService.lambdaUpdate();
        lambdaUpdate.eq(User::getId,user.getId());
        boolean flag = lambdaUpdate.set(User::getName, user.getName()).update();
        return flag? "修改成功":"失败";

    }

    @GetMapping("/delete")
    public String deleteData(@RequestParam("id") Integer id){
        boolean flag = userService.removeById(id);
        return flag? "删除成功":"失败";
    }
}
