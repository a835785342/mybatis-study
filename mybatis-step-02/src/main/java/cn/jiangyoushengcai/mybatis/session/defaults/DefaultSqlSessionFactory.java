package cn.jiangyoushengcai.mybatis.session.defaults;

import cn.jiangyoushengcai.mybatis.binding.MapperRegistry;
import cn.jiangyoushengcai.mybatis.session.SqlSession;
import cn.jiangyoushengcai.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
