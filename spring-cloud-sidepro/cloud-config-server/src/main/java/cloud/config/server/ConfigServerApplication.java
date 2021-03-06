package cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


//@Configuration
//@EnableAutoConfiguration
//@EnableDiscoveryClient
//@SpringBootApplication
//@EnableConfigServer//读取远程配置文件，转换为rest接口服务

@SpringBootApplication
@EnableConfigServer//读取远程配置文件，转换为rest接口服务
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}

