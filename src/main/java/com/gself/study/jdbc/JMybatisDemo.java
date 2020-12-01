package com.gself.study.jdbc;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLOrderBy;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;

import java.util.List;

/**
 * Created by guott on 2020/12/1 11:37
 *
 * mybatis ast语法树演示
 */
public class JMybatisDemo {
    public void m(){
        String sql = "select A.* from  A where A.address = (select address from B where id = 10) ";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        SQLSelectStatement statement = (SQLSelectStatement) parser.parseStatement();
        statement.accept(visitor);
        System.out.println(visitor.getConditions().get(0));
        SQLSelect select = statement.getSelect();
        MySqlSelectQueryBlock query = (MySqlSelectQueryBlock) select.getQuery();
        SQLExpr where = query.getWhere();
        List<SQLSelectItem> selectList = query.getSelectList();
        SQLOrderBy orderBy = query.getOrderBy();
        System.out.println(where);
        System.out.println(selectList.get(0));
        System.out.println(orderBy);
        System.out.println("------------------");
        selectList.forEach(e->{
            SQLExpr expr = e.getExpr();
            System.out.println(1);
        });
    }
}
