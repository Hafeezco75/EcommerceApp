package com.jumia.services;

import com.jumia.data.models.*;
import com.jumia.data.repositories.BillingInformationRepository;
import com.jumia.dtos.requests.AddBillingInformationRequest;
import com.jumia.dtos.requests.ModifyBillingInformationRequest;
import com.jumia.dtos.requests.RemoveBillingInformationRequest;
import com.jumia.dtos.responses.AddBillingInformationResponse;
import com.jumia.dtos.responses.ModifyBillingInformationResponse;
import com.jumia.dtos.responses.RemoveBillingInformationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillingInformationServiceImpl implements BillingInformationService {

    private final BillingInformationRepository billingInformationRepository;


    @Override
    public AddBillingInformationResponse addBillingInformation(AddBillingInformationRequest addBillingInformationRequest) {
        BillingInformation billingInformations = new BillingInformation();
        billingInformations.setCustomers(new Customers());
        billingInformations.setCreditCardInformation(addBillingInformationRequest.getCreditCardInformation());
        billingInformations.setAddresses(addBillingInformationRequest.getAddresses());
        billingInformationRepository.save(billingInformations);

        AddBillingInformationResponse addBillingResponse = new AddBillingInformationResponse();
        addBillingResponse.setMessage("Billing Information Added to User Account");
        return addBillingResponse;
    }

    @Override
    public RemoveBillingInformationResponse removeBillingInformation(RemoveBillingInformationRequest removeBillingInformationRequest){
        RemoveBillingInformationResponse removeBillingResponse = new RemoveBillingInformationResponse();
        List<BillingInformation> billingInformations = billingInformationRepository.findAll();
        for (BillingInformation billInformation : billingInformations) {
            if (billInformation.getCreditCardInformation().equals(removeBillingInformationRequest.getCreditCardInformation())) {
                billingInformationRepository.delete(billInformation);
                removeBillingResponse.setMessage("Billing Information Removed from User Account");
            }else {
                throw new IllegalArgumentException("Incorrect Credit Card Information");
            }
        }
        return removeBillingResponse;
    }

    @Override
    public ModifyBillingInformationResponse modifyBillingInformation(ModifyBillingInformationRequest modifyBillingInformationRequest){
        ModifyBillingInformationResponse modifyBillingResponse = new ModifyBillingInformationResponse();
        List<BillingInformation> billingInformations = billingInformationRepository.findAll();
        for (BillingInformation billingInformation : billingInformations) {
            if (billingInformation != null) {
                billingInformation.setCreditCardInformation(modifyBillingInformationRequest.getCreditCardInformation());
                billingInformation.setAddresses(modifyBillingInformationRequest.getAddresses());
                billingInformationRepository.save(billingInformation);
                modifyBillingResponse.setMessage("Billing Information successfully Updated");
            }else {
                throw new IllegalArgumentException("Incorrect Credit Card Information");
            }
        }
        return modifyBillingResponse;
    }

    @Override
    public List<BillingInformation> getAllBillingInformation(){
        return billingInformationRepository.findAll();
    }
}
