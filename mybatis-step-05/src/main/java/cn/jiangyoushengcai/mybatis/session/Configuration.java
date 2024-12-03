package cn.jiangyoushengcai.mybatis.session;

import cn.jiangyoushengcai.mybatis.binding.MapperRegistry;
import cn.jiangyoushengcai.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.jiangyoushengcai.mybatis.mapping.Environment;
import cn.jiangyoushengcai.mybatis.mapping.MappedStatement;
import cn.jiangyoushengcai.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.jiangyoushengcai.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    //映射语句，保存在Map中
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();
    //类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
    //环境
    protected Environment environment;
    //映射器注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

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
    
    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
