package com.jumia.web;

import com.jumia.data.models.BillingInformation;
import com.jumia.dtos.requests.AddBillingInformationRequest;
import com.jumia.dtos.requests.ModifyBillingInformationRequest;
import com.jumia.dtos.requests.RemoveBillingInformationRequest;
import com.jumia.dtos.responses.AddBillingInformationResponse;
import com.jumia.dtos.responses.ApiResponse;
import com.jumia.dtos.responses.ModifyBillingInformationResponse;
import com.jumia.dtos.responses.RemoveBillingInformationResponse;
import com.jumia.services.BillingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3")
public class BillingInformationController {
    @Autowired
    BillingInformationService billingInformationService;


    @PostMapping("/add")
    public ResponseEntity<?> addBillingInformation(AddBillingInformationRequest addBillingInformationRequest) {
        try {
            AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(addBillingInformationRequest);
            return new ResponseEntity<>(addBillingInformationResponse, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeBillingInformation(RemoveBillingInformationRequest removeBillingInformationRequest) {
        try {
            RemoveBillingInformationResponse removeBillingInformationResponse = billingInformationService.removeBillingInformation(removeBillingInformationRequest);
            return new ResponseEntity<>(removeBillingInformationResponse, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/Edit")
    public ResponseEntity<?> modifyBillingInformation(ModifyBillingInformationRequest modifyBillingInformationRequest) {
        try {
            ModifyBillingInformationResponse modifyBillingInformationResponse = billingInformationService.modifyBillingInformation(modifyBillingInformationRequest);
            return new ResponseEntity<>(modifyBillingInformationResponse, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Get")
    public ResponseEntity<?> getAllBillingInformation() {
        try {
            List<BillingInformation> billingInformation = billingInformationService.getAllBillingInformation();
            return new ResponseEntity<>(billingInformation, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}