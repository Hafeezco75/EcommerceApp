package com.jumia.services;

import com.jumia.data.models.*;
import com.jumia.dtos.requests.AddBillingInformationRequest;
import com.jumia.dtos.requests.ModifyBillingInformationRequest;
import com.jumia.dtos.requests.RemoveBillingInformationRequest;
import com.jumia.dtos.responses.AddBillingInformationResponse;
import com.jumia.dtos.responses.ModifyBillingInformationResponse;
import com.jumia.dtos.responses.RemoveBillingInformationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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

    @Test
    public void testThatBillingInformationCanBeUpdated() {
        ModifyBillingInformationRequest modifyBillingInformationRequest = new ModifyBillingInformationRequest();
        modifyBillingInformationRequest.setCreditCardInformation(new CreditCardInformation("424","Buchi Manda",46553224598764L, Month.FEBRUARY, LocalDate.now(), CardType.AMERICANEXPRESS));
        modifyBillingInformationRequest.setAddresses(new Addresses(21,"Obi Nwaeze Street",State.ABIA,"Abia Municipal","Nigeria"));
        ModifyBillingInformationResponse modifyBillingInformationResponse = billingInformationService.modifyBillingInformation(modifyBillingInformationRequest);
        assertThat(modifyBillingInformationResponse.getMessage()).isNotNull();
        assertThat(modifyBillingInformationResponse.getMessage()).isEqualTo("Billing Information successfully Updated");
    }

    @Test
    public void testThatBillingInformationCanBeRetrieved() {
        List<BillingInformation> billingInformations = billingInformationService.getAllBillingInformation();
        billingInformations.set(1, new BillingInformation());
        assertThat(billingInformations.size()).isEqualTo(6);
    }
}
