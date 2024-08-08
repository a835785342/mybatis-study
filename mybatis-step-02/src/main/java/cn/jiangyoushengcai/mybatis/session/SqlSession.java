package cn.jiangyoushengcai.mybatis.session;

public interface SqlSession {

    Object selectOne(String statement);

    Object selectOne(String statement,Object parameter);

    <T> T getMapper(Class<T> type);
}
