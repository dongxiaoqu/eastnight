package cn.eastnight.common.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>标题：config数据源配置</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.common.datasource.ConfigDataSourceConfig</p>
 * <p>创建日期：2021/7/12 11:12</p>
 */
public class ConfigDataSourceConfig {
    @Bean(name = "configConfig")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.config")
    public DataSource configConfig() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "configSessionFactory")
    public SqlSessionFactory baseSessionFactory(@Qualifier("configConfig") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/datasources/mapper/db2/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager baseTransactionManager(@Qualifier("configConfig") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate baseSqlSessionTemplate(@Qualifier("configSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
