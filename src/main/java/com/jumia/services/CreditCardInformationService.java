package com.jumia.services;

import com.jumia.data.models.CreditCardInformation;
import com.jumia.dtos.requests.AddCreditCardInformationRequest;
import com.jumia.dtos.requests.ModifyCreditCardInformationRequest;
import com.jumia.dtos.requests.RemoveCreditCardInformationRequest;
import com.jumia.dtos.responses.AddCreditCardInformationResponse;
import com.jumia.dtos.responses.ModifyCreditCardInformationResponse;
import com.jumia.dtos.responses.RemoveCreditCardInformationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditCardInformationService {

    AddCreditCardInformationResponse addCreditCardInformation(AddCreditCardInformationRequest addCreditCardInformationRequest);

    RemoveCreditCardInformationResponse removeCreditCardInformation(RemoveCreditCardInformationRequest removeCreditCardInformationRequest);

    ModifyCreditCardInformationResponse modifyCreditCard(ModifyCreditCardInformationRequest modifyCreditCardInformationRequest);

    List<CreditCardInformation> getCreditCardInformation();
}
