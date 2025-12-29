package org.kas.demos.Prac.CoderpatQuest.DAY33_07_11.JPAQUest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query using JOIN FETCH to load subjects eagerly within the query
    @Query("SELECT u FROM User u JOIN FETCH u.subjects s WHERE u.userId = :userId")
    Optional<User> findUserWithSubjectsByUserId(Long userId);
}
