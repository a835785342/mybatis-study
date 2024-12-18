package cn.jiangyoushengcai.mybatis.mapping;

import cn.jiangyoushengcai.mybatis.session.Configuration;

public class MappedStatement {
    private Configuration configuration;
    private String id;
    private SqlCommandType sqlCommandType;
    
    private BoundSql boundSql;

    MappedStatement() {

    }

    public static class Builder {
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, BoundSql boundSql) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.boundSql = boundSql;
        }
        
        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }

    public String getId() {
        return id;
    }
    
    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public BoundSql getBoundSql() {
        return boundSql;
    }
}
