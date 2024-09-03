package cn.jiangyoushengcai.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import cn.jiangyoushengcai.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapperRegistry {

    private final Map<Class<?>, MapperProxyFactory<?>> knowMapper = new HashMap<>();

    public <T> void addMapper(Class<T> type) {
        if (!type.isInterface()) {
            throw new RuntimeException("Mapper必须为接口类");
        }
        knowMapper.put(type, new MapperProxyFactory(type));
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory mapperProxyFactory = knowMapper.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("该接口类型未注册");
        }
        return (T) mapperProxyFactory.newInstance(sqlSession);
    }

    public void scanMappers(String packageName) {
        Set<Class<?>> classes = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : classes) {
            addMapper(mapperClass);
        }
    }
}
