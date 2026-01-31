package org.kas.demos.Prac.CoderpatQuest.Day21_16_10.ConnectingTwoDb;

// SecondaryDbConfig.java
    @Configuration
    @EnableTransactionManagement
    @EnableJpaRepositories(
        basePackages = "com.example.secondary.repository",
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager"
    )
    public class SecondaryDbConfig {

        @Bean
        @ConfigurationProperties(prefix = "secondary.datasource")
        public DataSource secondaryDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
                EntityManagerFactoryBuilder builder, @Qualifier("secondaryDataSource") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.example.secondary.entity")
                    .persistenceUnit("secondary")
                    .build();
        }

        @Bean
        public PlatformTransactionManager secondaryTransactionManager(
                @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
    }