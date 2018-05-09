package com.comic.www.dao;



import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

import static org.springframework.util.Assert.notNull;

/**
 * @文件名：MybatisDAO.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-7
 * @功能描述：数据库基本操作，如果有复杂逻辑每个模块可以自己在写一个DAO文件，继承该DAO；
 * @如果只是普通的CRUD使用该DAO即可
 */
@Repository
public class MybatisDAO extends DaoSupport {
    private static final Logger logger = LoggerFactory.getLogger(MybatisDAO.class);

    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;
    private boolean externalSqlSession;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        if (!this.externalSqlSession) {
            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSession = sqlSessionTemplate;
        this.externalSqlSession = true;
    }

    /**
     * {@inheritDoc}
     */
    protected void checkDaoConfig() {
        notNull(this.sqlSession, "Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
    }

    public int insert(String key, Object object) {
        return sqlSession.insert(key, object);
    }


    public int delete(String key, Object object) {
        return sqlSession.delete(key, object);
    }

    public int update(String key, Object object) {
        return sqlSession.update(key, object);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Object object) {
        return (T) sqlSession.selectOne(key, object);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) sqlSession.selectOne(key);
    }

    public int count(String key, Object object) {
        return (Integer) sqlSession.selectOne(key, object);
    }

    public <T> List<T> getList(String key) {
        return sqlSession.selectList(key);
    }

    public <T> List<T> getList(String key, Object object) {
        return sqlSession.selectList(key, object);
    }


    public void select(String key, Object params, ResultHandler resultHandler){
        sqlSession.select(key,params,resultHandler);
    }

    /**
     * @函数介绍：获取原始sql连接
     * @参数：
     * @返回值：
     */
    public Connection getConnection() {
        SqlSession session = this.sqlSessionFactory.openSession();
        return session.getConnection();
    }
}