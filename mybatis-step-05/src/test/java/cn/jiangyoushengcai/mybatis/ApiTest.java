package cn.jiangyoushengcai.mybatis;

import cn.hutool.json.JSONUtil;
import cn.jiangyoushengcai.mybatis.dao.IUserDao;
import cn.jiangyoushengcai.mybatis.io.Resources;
import cn.jiangyoushengcai.mybatis.po.User;
import cn.jiangyoushengcai.mybatis.session.SqlSession;
import cn.jiangyoushengcai.mybatis.session.SqlSessionFactory;
import cn.jiangyoushengcai.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;

public class ApiTest {

    @Test
    public void test_MapperProxyFactory() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.queryUserAge("1");

        System.out.println("测试结果:" + JSONUtil.toJsonPrettyStr(user));

    }
}
