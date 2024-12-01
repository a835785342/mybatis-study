package cn.jiangyoushengcai.mybatis.session.defaults;

import cn.jiangyoushengcai.mybatis.mapping.MappedStatement;
import cn.jiangyoushengcai.mybatis.session.Configuration;
import cn.jiangyoushengcai.mybatis.session.SqlSession;

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + " \n入参：" + parameter + "\n待执行sql" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return this.configuration.getMapper(type, this);
    }
}
