package cn.jiangyoushengcai.mybatis.builder;

import cn.jiangyoushengcai.mybatis.session.Configuration;

public class BaseBuilder {
    
    protected Configuration configuration;
    
    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
