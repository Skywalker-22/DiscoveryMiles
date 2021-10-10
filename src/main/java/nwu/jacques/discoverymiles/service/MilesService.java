package nwu.jacques.discoverymiles.service;

import nwu.jacques.discoverymiles.entity.MileTransaction;
import nwu.jacques.discoverymiles.entity.User;
import nwu.jacques.discoverymiles.exception.ResourceNotFoundException;
import nwu.jacques.discoverymiles.model.UserMilesModel;
import nwu.jacques.discoverymiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MilesService {
    @Autowired
    private UserRepository userRepository;

    public UserMilesModel getUserMiles(long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for id : " + userId));

        var transactions = user.getMileTransactions();

        transactions.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));

        Date lastTransactionDate = null;

        if (transactions.size() > 0) {
            lastTransactionDate = transactions.get(transactions.size() - 1).getDate();
        }

        return new UserMilesModel(user.getMiles(), lastTransactionDate, user.getUsername());
    }

    public void addSubtractMiles(Long userId, double miles, Date date) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for id : " + userId));

        double newBalance = user.getMiles() + miles;

        var newTransaction = new MileTransaction();
        newTransaction.setUser(user);
        newTransaction.setValue(miles);
        newTransaction.setRunningBalance(newBalance);

        if (date == null) {
            newTransaction.setDate(new Date());
        } else {
            newTransaction.setDate(date);
        }

        user.setMiles(newBalance);
        user.addMileTransaction(newTransaction);

        userRepository.save(user);
    }
}
