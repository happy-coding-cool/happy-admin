package com.happy.admin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author happycoding@aliyun.com
 * @since 2021-05-10 14:06:47
 */
@SpringBootApplication
@MapperScan("com.happy.admin.**.mapper")
public class HappyAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(HappyAdminApplication.class, args);
    }
}
