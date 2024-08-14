package com.jumia.services;

import com.jumia.data.models.*;
import com.jumia.dtos.requests.AddBillingInformationRequest;
import com.jumia.dtos.requests.RemoveBillingInformationRequest;
import com.jumia.dtos.responses.AddBillingInformationResponse;
import com.jumia.dtos.responses.RemoveBillingInformationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BillingInformationServiceImplTest {
    @Autowired
    BillingInformationService billingInformationService;



    @Test
    public void testThatBillingInformationCanBeAdded() {
        AddBillingInformationRequest addBillingInformationRequest = new AddBillingInformationRequest();
        addBillingInformationRequest.setCreditCardInformation(new CreditCardInformation("432","Buchi Manda",46553224598764L, Month.FEBRUARY, LocalDate.now(), CardType.MASTERCARD));
        addBillingInformationRequest.setAddresses(new Addresses(25,"Obi Nwanem Street",State.ABIA,"Isialangwa","Nigeria"));
        AddBillingInformationResponse addBillingInformationResponse = billingInformationService.addBillingInformation(addBillingInformationRequest);
        assertThat(addBillingInformationResponse.getMessage()).isNotNull();
        assertThat(addBillingInformationResponse.getMessage()).isEqualTo("Billing Information Added to User Account");
    }

    @Test
    public void testThatBillingInformationCanBeDeleted() {
        RemoveBillingInformationRequest removeBillingInformationRequest = new RemoveBillingInformationRequest();
        removeBillingInformationRequest.setCreditCardInformation(new CreditCardInformation("432","Buchi Manda",46553224598764L, Month.FEBRUARY, LocalDate.now(), CardType.MASTERCARD));
        removeBillingInformationRequest.setAddresses(new Addresses(25,"Obi Nwanem Street",State.ABIA,"Isialangwa","Nigeria"));
        RemoveBillingInformationResponse removeBillingInformationResponse = billingInformationService.removeBillingInformation(removeBillingInformationRequest);
        assertThat(removeBillingInformationResponse.getMessage()).isNotNull();
        assertThat(removeBillingInformationResponse.getMessage()).isEqualTo("Billing Information Removed From User Account");
    }

}
