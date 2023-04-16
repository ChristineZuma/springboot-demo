package cn.itcast.service;

import cn.itcast.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {
    boolean insertUser(User user);

    IPage getList(String name);
}
