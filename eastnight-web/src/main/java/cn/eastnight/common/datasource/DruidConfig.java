package cn.eastnight.common.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * <p>标题：druid数据源配置类</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.common.datasource.DruidConfig</p>
 * <p>创建日期：2021/7/12 10:44</p>
 */
@Configuration
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.base")
    public DataSource druid() {
        return new DruidDataSource();
    }
}
