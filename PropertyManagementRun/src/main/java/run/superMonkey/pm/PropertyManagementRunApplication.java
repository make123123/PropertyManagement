package run.superMonkey.pm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("run.superMonkey.pm.mapper")
public class PropertyManagementRunApplication {
//123
	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementRunApplication.class, args);
	}

}
