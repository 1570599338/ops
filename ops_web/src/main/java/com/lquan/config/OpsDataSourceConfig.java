package com.lquan.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * ClassName OpsDataSourceConfig
 *
 * @Author lquan
 * @Description  数据库数据源配置
 * @Date
 * @Param
 * @return
 **/
@Configuration
@MapperScan(basePackages = {"com.lquan"},sqlSessionFactoryRef = "opsSqlSessionFactory")
public class OpsDataSourceConfig {

    @Bean(name = "opsDataSource",initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource.ops")
    public DataSource dataSource() {
        return  DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "opsTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("opsDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "opsSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("opsDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("reasonable", "false");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props);
        //添加插件
        factoryBean.setPlugins(new Interceptor[]{pageHelper});
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            factoryBean.setMapperLocations(resolver.getResources("classpath*:mappers/mysql/ops/*Mapper.xml"));
            return factoryBean.getObject();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
