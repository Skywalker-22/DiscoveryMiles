package nwu.jacques.discoverymiles.repository;

import nwu.jacques.discoverymiles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
