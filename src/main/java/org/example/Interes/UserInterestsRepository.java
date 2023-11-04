package org.example.Interes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterestsRepository extends JpaRepository<UsersInterests, Integer> {
    void deleteAllByUserId(Integer userID);
}
