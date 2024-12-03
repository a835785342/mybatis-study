package cn.jiangyoushengcai.mybatis.session.defaults;

import cn.jiangyoushengcai.mybatis.session.Configuration;
import cn.jiangyoushengcai.mybatis.session.SqlSession;
import cn.jiangyoushengcai.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
