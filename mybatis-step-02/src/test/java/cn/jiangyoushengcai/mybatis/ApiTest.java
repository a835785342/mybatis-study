package cn.jiangyoushengcai.mybatis;

import cn.jiangyoushengcai.mybatis.binding.MapperRegistry;
import cn.jiangyoushengcai.mybatis.dao.IUserDao;
import cn.jiangyoushengcai.mybatis.session.SqlSession;
import cn.jiangyoushengcai.mybatis.session.SqlSessionFactory;
import cn.jiangyoushengcai.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_MapperProxyFactory(){

        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.scanMappers("cn.jiangyoushengcai.mybatis.dao");

        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        String res = iUserDao.queryUserName("123");

        System.out.println(res);

    }
}
