package cn.jiangyoushengcai.mybatis.binding;

import cn.jiangyoushengcai.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler {

    private SqlSession sqlSession;
    private Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return sqlSession.selectOne(method.getName(), args);
    }
}
