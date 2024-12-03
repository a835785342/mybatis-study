package cn.jiangyoushengcai.mybatis.transaction.jdbc;

import cn.jiangyoushengcai.mybatis.session.TransactionIsolationLevel;
import cn.jiangyoushengcai.mybatis.transaction.Transaction;
import cn.jiangyoushengcai.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection connection) {
        return new JdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
