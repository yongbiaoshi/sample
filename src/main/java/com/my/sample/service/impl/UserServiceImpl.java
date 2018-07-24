package com.my.sample.service.impl;

import com.my.sample.entity.po.User;
import com.my.sample.mapper.UserMapper;
import com.my.sample.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shiyongbiao
 * @since 2018-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
