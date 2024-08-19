package com.jumia.services;

import com.jumia.data.models.BillingInformation;
import com.jumia.dtos.requests.AddBillingInformationRequest;
import com.jumia.dtos.requests.ModifyBillingInformationRequest;
import com.jumia.dtos.requests.RemoveBillingInformationRequest;
import com.jumia.dtos.responses.AddBillingInformationResponse;
import com.jumia.dtos.responses.ModifyBillingInformationResponse;
import com.jumia.dtos.responses.RemoveBillingInformationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillingInformationService {

    AddBillingInformationResponse addBillingInformation(AddBillingInformationRequest addBillingInformationRequest);

    RemoveBillingInformationResponse removeBillingInformation(RemoveBillingInformationRequest removeBillingInformationRequest);

    ModifyBillingInformationResponse modifyBillingInformation(ModifyBillingInformationRequest modifyBillingInformationRequest);

    List<BillingInformation> getAllBillingInformation();
}
