package cn.jiangyoushengcai.mybatis.transaction.jdbc;

import cn.jiangyoushengcai.mybatis.session.TransactionIsolationLevel;
import cn.jiangyoushengcai.mybatis.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTransaction implements Transaction {

    protected Connection connection;
    protected DataSource dataSource;
    protected TransactionIsolationLevel transactionIsolationLevel;
    protected boolean autoCommit;
    
    public JdbcTransaction(Connection connection){
        this.connection = connection;
    }

    public JdbcTransaction(DataSource dataSource, TransactionIsolationLevel transactionIsolationLevel, boolean autoCommit) {
        this.dataSource = dataSource;
        this.transactionIsolationLevel = transactionIsolationLevel;
        this.autoCommit = autoCommit;
    }

    @Override
    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setTransactionIsolation(transactionIsolationLevel.getLevel());
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    @Override
    public void commit() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.commit();
        }
    }

    @Override
    public void rollback() throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }
}
