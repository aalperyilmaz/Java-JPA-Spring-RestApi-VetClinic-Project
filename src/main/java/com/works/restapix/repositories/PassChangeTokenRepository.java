package com.works.restapix.repositories;

import com.works.restapix.entities.PasswordResetToken;
import com.works.restapix.properties.PassChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassChangeTokenRepository extends JpaRepository<PasswordResetToken,Integer> {
    PasswordResetToken findByTokenEquals(String token);
}
