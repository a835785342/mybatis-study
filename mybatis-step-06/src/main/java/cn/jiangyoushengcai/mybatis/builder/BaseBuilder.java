package cn.jiangyoushengcai.mybatis.builder;

import cn.jiangyoushengcai.mybatis.session.Configuration;
import cn.jiangyoushengcai.mybatis.type.TypeAliasRegistry;

public class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;
    
    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
