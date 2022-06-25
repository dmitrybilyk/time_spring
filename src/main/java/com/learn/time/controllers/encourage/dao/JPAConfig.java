//package com.learn.time.controllers.encourage.dao;
//
////import com.zoomint.encourage.common.eclipselink.Jsr310JpaConverters;
////import com.zoomint.encourage.common.eclipselink.Slf4JEclipseLinkSessionLogger;
////import com.zoomint.encourage.common.model.CommonEntity;
////import com.zoomint.encourage.data.access.dao.converters.UserStateConverter;
////import org.eclipse.persistence.logging.SessionLog;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
//import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.SharedCacheMode;
//
////import static org.eclipse.persistence.config.PersistenceUnitProperties.*;
//
//@Configuration
//@ComponentScan("com.learn.time.controllers.encourage.dao")
//@EnableJpaRepositories(
//		basePackages = "com.learn.time.controllers.encourage.dao",
//		repositoryBaseClass = DefaultDaoImpl.class)
//@EnableTransactionManagement
//public class JPAConfig {
//
//	@Autowired
//	public DataAccessProperties properties;
//
//	@Bean
//	public DriverManagerDataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(properties.getDatabase().getDriver());
//		dataSource.setUrl(properties.getDatabase().getAddress());
//		dataSource.setUsername(properties.getDatabase().getUsername());
//		dataSource.setPassword(properties.getDatabase().getPassword());
//		return dataSource;
//	}
//
//	@Bean
//	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
//		jpaTransactionManager.setDataSource(dataSource());
//		return jpaTransactionManager;
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setPackagesToScan(
////				CommonEntity.class.getPackage().getName(),
//				EventEntity.class.getPackage().getName()
////				UserStateConverter.class.getPackage().getName(),
////				Jsr310JpaConverters.class.getPackage().getName()
//			);
//		factory.setDataSource(dataSource());
//		factory.setJpaVendorAdapter(jpaVendorAdapter());
//		factory.setJpaDialect(jpaDialect());
//		factory.setSharedCacheMode(SharedCacheMode.NONE); // cache fully disabled
////		factory.getJpaPropertyMap().put(WEAVING, "false");
////		factory.getJpaPropertyMap().put(LOGGING_PARAMETERS, "true");
////		factory.getJpaPropertyMap().put(LOGGING_LEVEL, SessionLog.INFO_LABEL);
////		factory.getJpaPropertyMap().put(LOGGING_LOGGER, Slf4JEclipseLinkSessionLogger.class.getName());
//		return factory;
//	}
//
//	@Bean
//	public EclipseLinkJpaDialect jpaDialect() {
//		EclipseLinkJpaDialect jpaDialect = new EclipseLinkJpaDialect();
//		jpaDialect.setLazyDatabaseTransaction(true);
//		return jpaDialect;
//	}
//
//	@Bean
//	public EclipseLinkJpaVendorAdapter jpaVendorAdapter() {
//		EclipseLinkJpaVendorAdapter jpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
//		jpaVendorAdapter.setShowSql(true);
//		jpaVendorAdapter.setDatabase(properties.getDatabase().getType());
//		return jpaVendorAdapter;
//	}
//}
