package com.jumia.web;

import com.jumia.dtos.requests.AddCreditCardInformationRequest;
import com.jumia.dtos.requests.ModifyCreditCardInformationRequest;
import com.jumia.dtos.requests.RemoveCreditCardInformationRequest;
import com.jumia.dtos.responses.AddCreditCardInformationResponse;
import com.jumia.dtos.responses.ApiResponse;
import com.jumia.dtos.responses.ModifyCreditCardInformationResponse;
import com.jumia.dtos.responses.RemoveCreditCardInformationResponse;
import com.jumia.services.CreditCardInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardInformationController {
    @Autowired
    private CreditCardInformationService creditCardInformationService;


    @PostMapping("/addCard")
    public ResponseEntity<?> addCreditCardInformation(AddCreditCardInformationRequest request) {
        try {
            AddCreditCardInformationResponse addCreditCardInformationResponse = creditCardInformationService.addCreditCardInformation(request);
            return new ResponseEntity<>(new ApiResponse(true, addCreditCardInformationResponse), HttpStatus.CREATED);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/removeCard")
    public ResponseEntity<?> removeCreditCardInformation(RemoveCreditCardInformationRequest request) {
        try {
            RemoveCreditCardInformationResponse removeCreditCardInformationResponse = creditCardInformationService.removeCreditCardInformation(request);
            return new ResponseEntity<>(new ApiResponse(true, removeCreditCardInformationResponse), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyCreditCard(ModifyCreditCardInformationRequest modifyCreditCardInformationRequest) {
        try {
            ModifyCreditCardInformationResponse modifyCreditCardInformationResponse = creditCardInformationService.modifyCreditCard(modifyCreditCardInformationRequest);
            return new ResponseEntity<>(new ApiResponse(true, modifyCreditCardInformationResponse), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
