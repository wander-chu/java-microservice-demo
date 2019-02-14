package springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "springboottest.mapper")
public class SpringboottestApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(SpringboottestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringboottestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("服务启动完成!");
    }
}

