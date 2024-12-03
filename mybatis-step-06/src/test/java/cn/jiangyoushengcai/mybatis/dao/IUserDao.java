package cn.jiangyoushengcai.mybatis.dao;

import cn.jiangyoushengcai.mybatis.po.User;

public interface IUserDao {

    String queryUserName(String uid);

    User queryUserAge(String uid);
}
