package learnSpringBoot.sample;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
public class Configure {

	@SuppressWarnings("rawtypes")
	@Bean(name="h2_db")
	@Profile("dev")
	public javax.sql.DataSource h2Database(){
		System.out.print("welcome to h2 database");
		DataSourceBuilder dsb=DataSourceBuilder.create();
		dsb.driverClassName("org.h2.driver");
		dsb.url("jdbc:h2:mem:student");
		dsb.username("sa");
		dsb.password("");
		return dsb.build();
		
	}

	
	@SuppressWarnings("rawtypes")
	@Bean(name="mysql_db")	
	@Profile("sit")
	public javax.sql.DataSource sqlDatabase(){
	System.out.print("welcome to h2 database");
	DataSourceBuilder dsb=DataSourceBuilder.create();
	dsb.driverClassName("com.mysql.jdbc.Driver");
	dsb.url("");
	dsb.username("root");
	dsb.password("1234");
	return dsb.build();
	
}
}