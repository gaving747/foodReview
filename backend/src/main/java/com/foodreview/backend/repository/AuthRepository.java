package com.foodreview.backend.repository;
import com.foodreview.backend.dto.generalInfoUsersResponse;
import com.foodreview.backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
    UserModel findByUsername(String username);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    @Query("""
            SELECT new com.foodreview.backend.dto.generalInfoUsersResponse(
                    u.email,
                    u.username)
            FROM UserModel u
            WHERE u.id = :id
            """)
    generalInfoUsersResponse getUserInfoFromDatabase(
            @Param("id") Long id
    );
}
