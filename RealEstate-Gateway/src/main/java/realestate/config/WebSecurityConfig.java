package realestate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import realestate.filter.JwtFilter;

@Configuration

public class WebSecurityConfig {

	
	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		//// @formatter:off
		http
		.httpBasic().disable()
		.formLogin().disable()
		.csrf().disable();
		
		return http.build();
		// @formatter:on

	}

	@Autowired
	private JwtFilter filter;

	//properties.yml dosyası içinde yapılan yönlendirme işlemi ile aynı işleve sahiptir.
	//lb:realestate ile servis isimlerine göre routelocator kullanılmıştır.
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
		//// @formatter:off

			
				.route("RealEstate-Auth", 
						r -> r.method(HttpMethod.POST)
							  .and()
							  .path("/auth/**")
							 
							  .uri("http://localhost:8083"))
				.route("RealEstate", 
						r -> r.method(HttpMethod.POST,HttpMethod.GET)
						      .and()
						      .path(("/adverts/**"))
						      .filters(f -> f.filter(filter)).uri("http://localhost:8080"))
				.route("RealEstate", 
						r -> r.method(HttpMethod.GET,HttpMethod.POST)
						.and()
						.path("/users/**")
						.filters(f -> f.filter(filter)).uri("http://localhost:8080"))
				.route("RealEstate-Payment",
						r -> r.method(HttpMethod.POST)
						.and()
						.path("/payments/**")
						.filters(f -> f.filter(filter)).uri("http://localhost:8081"))
				
				.build();
		
		// @formatter:on
	}

}
