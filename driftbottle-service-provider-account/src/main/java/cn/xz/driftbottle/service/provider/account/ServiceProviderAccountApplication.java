package cn.xz.driftbottle.service.provider.account;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"cn.xz.driftbottle"})
@EnableDiscoveryClient
@MapperScan(basePackages = {"cn.xz.driftbottle.commons.mapper"})
public class ServiceProviderAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderAccountApplication.class,args);
    }
}
