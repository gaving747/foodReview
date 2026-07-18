package com.foodreview.backend.repository;
import com.foodreview.backend.model.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.foodreview.backend.dto.generalInfoProfileResponse;


@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, Integer> {
    @Modifying
    @Query("""
            UPDATE ProfileModel p
            SET p.bio = :bio,
            p.displayName = :displayName
            WHERE p.userId = :userId
            """)
        int updateProfileInfo(
            @Param("bio") String bio,
            @Param("displayName") String displayName,
            @Param("userId") Long userId
        );

    @Query("""
            SELECT new com.foodreview.backend.dto.generalInfoProfileResponse(
                    p.displayName,
                    p.bio)
            FROM ProfileModel p
            WHERE p.userId = :userId
            """)
        generalInfoProfileResponse getProfileInfoFromDatabase(
            @Param("userId") Long userId
    );
}
