package com.jumia.services;

import com.jumia.dtos.requests.AddBillingInformationRequest;
import com.jumia.dtos.requests.RemoveBillingInformationRequest;
import com.jumia.dtos.responses.AddBillingInformationResponse;
import com.jumia.dtos.responses.RemoveBillingInformationResponse;
import org.springframework.stereotype.Service;

@Service
public interface BillingInformationService {

    AddBillingInformationResponse addBillingInformation(AddBillingInformationRequest addBillingInformationRequest);

    RemoveBillingInformationResponse removeBillingInformation(RemoveBillingInformationRequest removeBillingInformationRequest);
}
