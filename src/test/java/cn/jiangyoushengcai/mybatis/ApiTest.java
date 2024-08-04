package cn.jiangyoushengcai.mybatis;

import cn.jiangyoushengcai.mybatis.binding.MapperProxyFactory;
import cn.jiangyoushengcai.mybatis.dao.IUserDao;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    @Test
    public void test_MapperProxyFactory() {
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("cn.jiangyoushengcai.mybatis.dao.IUserDao#queryUserName","执行查询用户名称操作");

        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);
        IUserDao iUserDao = mapperProxyFactory.newInstance(sqlSession);

        String res = iUserDao.queryUserName("1");
        System.out.println(res);
    }
}
