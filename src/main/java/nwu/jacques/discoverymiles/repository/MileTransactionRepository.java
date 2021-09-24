package nwu.jacques.discoverymiles.repository;

import nwu.jacques.discoverymiles.entity.MileTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileTransactionRepository extends JpaRepository<MileTransaction, Long> {
}
