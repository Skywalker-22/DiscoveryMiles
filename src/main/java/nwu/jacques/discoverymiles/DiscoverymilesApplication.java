package nwu.jacques.discoverymiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DiscoverymilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverymilesApplication.class, args);
	}

}
