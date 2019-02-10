package com.luv2code.springdemo.config;

<<<<<<< HEAD
import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
=======
>>>>>>> aa0f6e1db17913fe06db0851365fcf8978e59ab3
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
<<<<<<< HEAD
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

=======
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

>>>>>>> aa0f6e1db17913fe06db0851365fcf8978e59ab3
@Configuration
@ComponentScan("com.luv2code.springdemo")
@EnableWebMvc
@EnableAspectJAutoProxy
<<<<<<< HEAD
@EnableTransactionManagement
public class AppConfiguration extends WebMvcConfigurerAdapter {

    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
=======
public class AppConfiguration {

>>>>>>> aa0f6e1db17913fe06db0851365fcf8978e59ab3
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}
<<<<<<< HEAD

	@Bean
	public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
		ComboPooledDataSource ds = new com.mchange.v2.c3p0.ComboPooledDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false");
		ds.setUser("root");
		ds.setPassword("root");

		ds.setMinPoolSize(5);
		ds.setMaxPoolSize(20);
		ds.setMaxIdleTime(30000);
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(comboPooledDataSource());
		sf.setPackagesToScan("com.luv2code.springdemo.entity");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", org.hibernate.dialect.MySQLDialect.class);
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
		sf.setHibernateProperties(hibernateProperties);
		return sf;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sf) throws PropertyVetoException {
		HibernateTransactionManager tm = new HibernateTransactionManager();
		tm.setSessionFactory(sf);
		return tm;
	}

=======
	
>>>>>>> aa0f6e1db17913fe06db0851365fcf8978e59ab3
}
