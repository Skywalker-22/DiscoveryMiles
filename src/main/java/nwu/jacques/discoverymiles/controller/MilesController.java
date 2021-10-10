package nwu.jacques.discoverymiles.controller;

import nwu.jacques.discoverymiles.exception.ResourceNotFoundException;
import nwu.jacques.discoverymiles.model.MileTransactionUpdateModel;
import nwu.jacques.discoverymiles.model.UserMilesModel;
import nwu.jacques.discoverymiles.service.MilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MilesController {
    @Autowired
    private MilesService milesService;

    @GetMapping("{id}")
    public ResponseEntity<UserMilesModel> getUserMiles(@PathVariable(value = "id") long userId) throws ResourceNotFoundException {
        var userMiles = milesService.getUserMiles(userId);
        return ResponseEntity.ok(userMiles);
    }

    @PostMapping("{id}/add")
    public ResponseEntity addMiles(@PathVariable(value = "id") long userId, @Valid @RequestBody MileTransactionUpdateModel model) throws ResourceNotFoundException {
        milesService.addSubtractMiles(userId, model.getValue(), model.getTransactionDate());
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/subtract")
    public ResponseEntity subtractMiles(@PathVariable(value = "id") long userId, @Valid @RequestBody MileTransactionUpdateModel model) throws ResourceNotFoundException {
        milesService.addSubtractMiles(userId, model.getValue() * -1, model.getTransactionDate());
        return ResponseEntity.ok().build();
    }
}
