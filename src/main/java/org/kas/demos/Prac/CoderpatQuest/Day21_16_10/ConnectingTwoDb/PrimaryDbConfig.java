package org.kas.demos.Prac.CoderpatQuest.Day21_16_10.ConnectingTwoDb;

// PrimaryDbConfig.java
    @Configuration
    @EnableTransactionManagement
    @EnableJpaRepositories(
        basePackages = "com.example.primary.repository",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager"
    )
    public class PrimaryDbConfig {

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "primary.datasource")
        public DataSource primaryDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean
        @Primary
        public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
                EntityManagerFactoryBuilder builder, @Qualifier("primaryDataSource") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.example.primary.entity")
                    .persistenceUnit("primary")
                    .build();
        }

        @Bean
        @Primary
        public PlatformTransactionManager primaryTransactionManager(
                @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
    }