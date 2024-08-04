package cn.jiangyoushengcai.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler {
    
    private Map<String,String> sqlSession;
    private Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return "你被代理了,"+sqlSession.get(mapperInterface.getName()+"#"+method.getName());
    }
}
