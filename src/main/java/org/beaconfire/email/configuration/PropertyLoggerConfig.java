package org.beaconfire.email.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.EnumerablePropertySource;
@Configuration
public class PropertyLoggerConfig {

    @Bean
    public CommandLineRunner logAllProperties(ConfigurableEnvironment env) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("===== Loaded Spring Properties =====");

                for (PropertySource<?> propertySource : env.getPropertySources()) {
                    if (propertySource instanceof EnumerablePropertySource) {
                        String[] propertyNames = ((EnumerablePropertySource<?>) propertySource).getPropertyNames();
                        for (String key : propertyNames) {
                            // Filter only relevant keys (optional)
                            if (key.contains("rabbitmq") || key.contains("mail")) {
                                String value = env.getProperty(key);
                                System.out.println(key + " = " + value);
                            }
                        }
                    }
                }

                System.out.println("====================================");
            }
        };
    }
}
