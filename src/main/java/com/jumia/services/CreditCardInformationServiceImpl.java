package com.jumia.services;
import com.jumia.data.models.CardType;
import com.jumia.data.models.CreditCardInformation;
import com.jumia.data.models.RoleType;
import com.jumia.data.repositories.CreditCardInformationRepository;
import com.jumia.dtos.requests.AddCreditCardInformationRequest;
import com.jumia.dtos.requests.RemoveCreditCardInformationRequest;
import com.jumia.dtos.responses.AddCreditCardInformationResponse;
import com.jumia.dtos.responses.RemoveCreditCardInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditCardInformationServiceImpl implements CreditCardInformationService {
    @Autowired
    private CreditCardInformationRepository creditCardInformationRepository;


    @Override
    public AddCreditCardInformationResponse addCreditCardInformation(AddCreditCardInformationRequest addCreditCardInformationRequest) {
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        creditCardInformation.setId("32");
        creditCardInformation.setName("Issac");
        creditCardInformation.setEmail("grazac@gmail.com");
        creditCardInformation.setPassword("Welcome342");
        creditCardInformation.setPhoneNumber("09087123456");
        creditCardInformation.setRole(RoleType.CUSTOMER);
        creditCardInformation.setCardCVV("321");
        creditCardInformation.setCardHolderName("Samson Balogun");
        creditCardInformation.setCardExpirationMonth(LocalDate.now());
        creditCardInformation.setCreditCardNumber(435677543329986L);
        creditCardInformation.setCardExpirationYear(LocalDate.ofYearDay(1987,23));
        creditCardInformation.setCardType(CardType.AMERICANEXPRESS);
        creditCardInformationRepository.save(creditCardInformation);

        AddCreditCardInformationResponse addCreditCardInformationResponse = new AddCreditCardInformationResponse();
        addCreditCardInformationResponse.setMessage("Credit card information successfully added");
        return addCreditCardInformationResponse;
    }


    @Override
    public RemoveCreditCardInformationResponse removeCreditCardInformation(RemoveCreditCardInformationRequest removeCreditCardInformationRequest){
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        creditCardInformation.setId("54");
        creditCardInformation.setName("Samson");
        creditCardInformation.setEmail("samson@gmail.com");
        creditCardInformation.setPassword("Welcome342");
        creditCardInformation.setPhoneNumber("09087123456");
        creditCardInformation.setRole(RoleType.CUSTOMER);
        creditCardInformation.setCardCVV("876");
        creditCardInformation.setCardHolderName("Samson Balogun");
        creditCardInformation.setCardExpirationMonth(LocalDate.now());
        creditCardInformation.setCreditCardNumber(435677543329986L);
        creditCardInformation.setCardExpirationYear(LocalDate.ofYearDay(1987,23));
        creditCardInformation.setCardType(CardType.AMERICANEXPRESS);


        RemoveCreditCardInformationResponse removeCreditCardInformationResponse = new RemoveCreditCardInformationResponse();
        removeCreditCardInformationResponse.setMessage("Credit Card Removed successfully");
        return removeCreditCardInformationResponse;
    }


}
