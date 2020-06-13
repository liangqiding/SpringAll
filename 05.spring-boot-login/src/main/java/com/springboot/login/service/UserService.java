package com.springboot.login.service;

import com.springboot.login.domain.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QiDing
 * @since 2020-06-13
 */
public interface UserService extends IService<User> {
  boolean checkAccount(User user);
}
