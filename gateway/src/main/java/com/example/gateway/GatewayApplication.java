package com.boughrous.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> {
			String ipAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
			System.out.println("Resolving rate limit key for IP: " + ipAddress);
			return Mono.just(ipAddress);
		};
	}


}
