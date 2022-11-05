package bankapp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@ComponentScan(basePackages={"bankapp"})
public class AppConfig {

    @Bean
    public CacheManager cacheManager() {
        CacheManager cacheManager = new ConcurrentMapCacheManager();
        return cacheManager;
    }
}