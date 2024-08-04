package cn.jiangyoushengcai.mybatis.dao;

public interface IUserDao {
    
    String queryUserName(String uid);
    
    Integer queryUserAge(String uid);
}
