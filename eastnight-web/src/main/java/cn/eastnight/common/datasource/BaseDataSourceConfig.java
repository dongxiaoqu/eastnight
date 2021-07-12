package cn.eastnight.common.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>标题：基础数据源配置</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.common.datasource.BaseDataSourceConfig</p>
 * <p>创建日期：2021/7/12 11:03</p>
 */
public class BaseDataSourceConfig {
    @Bean(name = "baseConfig")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.base")
    public DataSource baseConfig() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "baseSessionFactory")
    @Primary
    public SqlSessionFactory baseSessionFactory(@Qualifier("baseConfig") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/user/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager baseTransactionManager(@Qualifier("baseConfig") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("baseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate baseSqlSessionTemplate(@Qualifier("baseSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
