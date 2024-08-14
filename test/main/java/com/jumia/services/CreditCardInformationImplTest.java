package com.jumia.services;

import com.jumia.data.models.CardType;
import com.jumia.dtos.requests.AddCreditCardInformationRequest;
import com.jumia.dtos.requests.ModifyCreditCardInformationRequest;
import com.jumia.dtos.requests.RemoveCreditCardInformationRequest;
import com.jumia.dtos.responses.AddCreditCardInformationResponse;
import com.jumia.dtos.responses.ModifyCreditCardInformationResponse;
import com.jumia.dtos.responses.RemoveCreditCardInformationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CreditCardInformationImplTest {
    @Autowired
    private CreditCardInformationService creditCardInformationService;

    @Test
    public void testCreditCardInformationCanBeAdded() {
        AddCreditCardInformationRequest addCreditCardInformationRequest = new AddCreditCardInformationRequest();
        addCreditCardInformationRequest.setCardCVV("325");
        addCreditCardInformationRequest.setCreditCardNumber(543267890765437L);
        addCreditCardInformationRequest.setCardHolderName("Balogun Seyi");
        addCreditCardInformationRequest.setCardExpirationMonth(Month.JULY);
        addCreditCardInformationRequest.setCardExpirationYear(LocalDate.now());
        addCreditCardInformationRequest.setCardType(CardType.MASTERCARD);
        AddCreditCardInformationResponse addCreditCardInformationResponse = creditCardInformationService.addCreditCardInformation(addCreditCardInformationRequest);
        assertThat(addCreditCardInformationResponse.getMessage()).isEqualTo("Credit card information successfully added");
    }

    @Test
    public void testCreditCardInformationCanBeDeleted() {
       RemoveCreditCardInformationRequest removeCreditCardInformationRequest = new RemoveCreditCardInformationRequest();
       removeCreditCardInformationRequest.setCardCVV("352");
       removeCreditCardInformationRequest.setCardHolderName("Balogun Seyi");
       removeCreditCardInformationRequest.setCreditCardNumber(435677543329986L);
       removeCreditCardInformationRequest.setCardExpirationMonth(Month.DECEMBER);
       removeCreditCardInformationRequest.setCardExpirationYear(LocalDate.now());
       removeCreditCardInformationRequest.setCardType(CardType.MASTERCARD);
       RemoveCreditCardInformationResponse removeCreditCardInformationResponse = creditCardInformationService.removeCreditCardInformation(removeCreditCardInformationRequest);
       assertThat(removeCreditCardInformationResponse.getMessage()).isNotNull();
       assertThat(removeCreditCardInformationResponse.getMessage()).isEqualTo("Credit card information successfully deleted");
    }

    @Test
    public void testThatCreditCardInformationCanBeUpdated() {
        ModifyCreditCardInformationRequest modifyCreditCardInformationRequest = new ModifyCreditCardInformationRequest();
        modifyCreditCardInformationRequest.setCardCVV("438");
        modifyCreditCardInformationRequest.setCardHolderName("Muibi Seyi");
        modifyCreditCardInformationRequest.setCreditCardNumber(435677543329986L);
        modifyCreditCardInformationRequest.setCardExpirationMonth(Month.JULY);
        modifyCreditCardInformationRequest.setCardExpirationYear(LocalDate.now());
        modifyCreditCardInformationRequest.setCardType(CardType.VISA);
        ModifyCreditCardInformationResponse modifyCreditCardInformationResponse = creditCardInformationService.modifyCreditCard(modifyCreditCardInformationRequest);
        assertThat(modifyCreditCardInformationResponse.getMessage()).isNotNull();
        assertThat(modifyCreditCardInformationResponse.getMessage()).isEqualTo("Credit card information successfully updated");
    }
}
