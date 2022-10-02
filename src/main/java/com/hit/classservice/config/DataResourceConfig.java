package com.hit.classservice.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@MapperScan("com.hit.classservice.infrastructure.repository.database")
public class DataResourceConfig extends SpringBootServletInitializer {
  @Value("${spring.datasource.url}")
  private String datasourceUrl;

  @Value("${spring.datasource.username}")
  private String datasourceUserName;

  @Value("${spring.datasource.password}")
  private String datasourcePassword;

  @Value("${spring.datasource.driver-class-name}")
  private String datasourceDriverClassName;

  @Autowired
  @Bean
  public DataSourceTransactionManager transactionManager(
      @Qualifier("dataSource") DataSource dataSource) {

    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
    transactionManager.setDataSource(dataSource);

    return transactionManager;
  }

  @Autowired
  @Bean
  public SqlSessionTemplate sqlSessionTemplate(@Qualifier("dataSource") DataSource dataSource)
      throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);

    ResourcePatternResolver resolver =
        ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());

    // MyBatis のコンフィグレーションファイル
    bean.setConfigLocation(resolver.getResource("classpath:config/mybatis-config.xml"));
    // MyBatis で使用する SQL ファイル群
    bean.setMapperLocations(resolver.getResources("classpath:repository/*.xml"));

    return new SqlSessionTemplate(Objects.requireNonNull(bean.getObject()));
  }

  @Primary
  @Autowired
  @Bean
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(this.datasourceDriverClassName);
    dataSource.setUrl(this.datasourceUrl);
    dataSource.setUsername(this.datasourceUserName);
    dataSource.setPassword(this.datasourcePassword);
    return dataSource;
  }

}
