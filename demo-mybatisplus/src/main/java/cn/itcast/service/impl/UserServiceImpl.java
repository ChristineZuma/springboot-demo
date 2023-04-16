package cn.itcast.service.impl;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import cn.itcast.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private UserMapper userMapper;
    @Override
    public boolean insertUser(User user) {
        boolean flag = save(user);
        return flag;
    }

    @Override
    public IPage getList(String name) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(name),User::getName,name);
        Page<User> page = Page.of(1, 10);
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);
        return userPage;
    }


}
