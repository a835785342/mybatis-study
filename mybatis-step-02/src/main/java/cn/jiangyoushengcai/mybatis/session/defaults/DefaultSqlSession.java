package cn.jiangyoushengcai.mybatis.session.defaults;

import cn.jiangyoushengcai.mybatis.binding.MapperRegistry;
import cn.jiangyoushengcai.mybatis.session.SqlSession;

public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public Object selectOne(String statement) {
        return null;
    }

    @Override
    public Object selectOne(String statement, Object parameter) {
        return "你被代理了！" + "方法：" + statement + " 入参：" + parameter;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return this.mapperRegistry.getMapper(type, this);
    }
}
