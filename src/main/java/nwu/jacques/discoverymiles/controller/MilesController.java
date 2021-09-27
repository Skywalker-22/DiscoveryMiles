package nwu.jacques.discoverymiles.controller;

import nwu.jacques.discoverymiles.entity.MileTransaction;
import nwu.jacques.discoverymiles.exception.ResourceNotFoundException;
import nwu.jacques.discoverymiles.repository.MileTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MilesController {
    @Autowired
    private MileTransactionRepository mileTransactionRepository;

    @GetMapping("/mileTransaction")
    public List<MileTransaction> getAllMileTransactions() {
        return mileTransactionRepository.findAll();
    }

    @GetMapping("/milesTransaction/{id}")
    public ResponseEntity<MileTransaction> getMilesById(@PathVariable(value = "id") Long mileTransactionId) throws ResourceNotFoundException {
        MileTransaction mileTransaction = mileTransactionRepository.findById(mileTransactionId).orElseThrow(() -> new ResourceNotFoundException("Miles not found for id : " + mileTransactionId));
        return ResponseEntity.ok().body(mileTransaction);
    }

    @PostMapping("/mileTransaction")
    public MileTransaction createMileTransaction(@Valid @RequestBody MileTransaction mileTransaction) {
        return mileTransactionRepository.save(mileTransaction);
    }

    @PutMapping("/mileTransaction/{id}")
    public ResponseEntity<MileTransaction> updateMileTransaction(@PathVariable(value = "id") Long mileTransactionId, @Valid @RequestBody MileTransaction mileTransactionDetails) throws ResourceNotFoundException {
        MileTransaction mileTransaction = mileTransactionRepository.findById(mileTransactionId).orElseThrow(() -> new ResourceNotFoundException("Miles not found for id : " + mileTransactionId));

        mileTransaction.setRunningBalance(mileTransactionDetails.getRunningBalance());
        mileTransaction.setValue(mileTransactionDetails.getValue());

        final MileTransaction updatedMileTransaction = mileTransactionRepository.save(mileTransaction);
        return ResponseEntity.ok(updatedMileTransaction);
    }
}
