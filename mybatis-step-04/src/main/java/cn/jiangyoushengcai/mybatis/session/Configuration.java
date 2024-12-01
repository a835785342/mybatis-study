package cn.jiangyoushengcai.mybatis.session;

import cn.jiangyoushengcai.mybatis.binding.MapperRegistry;
import cn.jiangyoushengcai.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private MapperRegistry mapperRegistry = new MapperRegistry(this);

    private Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }
    
    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
}
