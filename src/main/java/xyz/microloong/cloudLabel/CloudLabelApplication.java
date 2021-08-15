package xyz.microloong.cloudLabel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import xyz.erupt.core.annotation.EruptScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * 启动类
 *
 * @author MicroLOONG
 * @date 2021-2-10
 */
@SpringBootApplication
@EntityScan
@EruptScan
@EnableJpaAuditing
public class CloudLabelApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CloudLabelApplication.class, args);
        System.err.println("详细使用方法，请阅读：README.md");
    }

    /**
     * 时区设置
     */
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    /**
     * 打WAR包的配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CloudLabelApplication.class);
    }
}
