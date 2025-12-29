package org.kas.demos.Prac.CoderpatQuest.Day21_16_10.ConnectingTwoDb;

// com.example.primary.entity.PrimaryEntity.java
    @Entity
    public class PrimaryEntity { /* ... */ }

    // com.example.primary.repository.PrimaryRepository.java
    public interface PrimaryRepository extends JpaRepository<PrimaryEntity, Long> { /* ... */ }

    // com.example.secondary.entity.SecondaryEntity.java
    @Entity
    public class SecondaryEntity { /* ... */ }

    // com.example.secondary.repository.SecondaryRepository.java
    public interface SecondaryRepository extends JpaRepository<SecondaryEntity, Long> { /* ... */ }