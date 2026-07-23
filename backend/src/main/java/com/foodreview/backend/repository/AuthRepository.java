package com.foodreview.backend.repository;
import com.foodreview.backend.dto.generalInfoUsersResponse;
import com.foodreview.backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("""
            UPDATE UserModel p
            SET p.email = :email,
            p.username = :username
            WHERE p.id = :id
            """)
    int updateUserInfo(
            @Param("email") String email,
            @Param("username") String username,
            @Param("id") Long id
    );

    @Query("""
            SELECT u from UserModel u
            WHERE u.id = :id
            """)
    UserModel findUserById(@Param("id") Long id);

    @Modifying
    @Query("""
            UPDATE UserModel p
            SET p.password = :password
            WHERE p.id = :id
            """)
    int updatePassword(
            @Param("password") String password,
            @Param("id") Long id
    );


    boolean existsByIdAndUsername(Long id, String username);
    boolean existsByIdAndEmail(Long id, String email);
}
