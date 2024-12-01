package cn.jiangyoushengcai.mybatis.binding;

import cn.jiangyoushengcai.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler {

    private final Class<T> mapperInterface;
    private final Map<Method, MapperMethod> methodCache;
    private SqlSession sqlSession;


    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MapperMethod> methodCache) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {

        }
        return sqlSession.selectOne(method.getName(), args);
    }
}
