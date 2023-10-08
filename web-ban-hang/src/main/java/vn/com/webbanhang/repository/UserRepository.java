package vn.com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.webbanhang.entity.Account;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {
    // TODO: su dung optional
    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
