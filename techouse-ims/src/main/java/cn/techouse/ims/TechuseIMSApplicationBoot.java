package cn.techouse.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableConfigurationProperties
@ImportResource("classpath:application-*.xml")
@EnableJpaRepositories()
public class TechuseIMSApplicationBoot {
	
	public static void main(String[] args) {
		SpringApplication.run(TechuseIMSApplicationBoot.class,args);
	}
}
