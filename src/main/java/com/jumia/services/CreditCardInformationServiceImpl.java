package com.jumia.services;
import com.jumia.data.models.CreditCardInformation;
import com.jumia.data.repositories.CreditCardInformationRepository;
import com.jumia.dtos.requests.AddCreditCardInformationRequest;
import com.jumia.dtos.requests.ModifyCreditCardInformationRequest;
import com.jumia.dtos.requests.RemoveCreditCardInformationRequest;
import com.jumia.dtos.responses.AddCreditCardInformationResponse;
import com.jumia.dtos.responses.ModifyCreditCardInformationResponse;
import com.jumia.dtos.responses.RemoveCreditCardInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CreditCardInformationServiceImpl implements CreditCardInformationService {
    @Autowired
    private CreditCardInformationRepository creditCardInformationRepository;


    @Override
    public AddCreditCardInformationResponse addCreditCardInformation(AddCreditCardInformationRequest addCreditCardInformationRequest) {
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        creditCardInformation.setRole(addCreditCardInformationRequest.getRoleType());
        creditCardInformation.setCardCVV(addCreditCardInformationRequest.getCardCVV());
        creditCardInformation.setCardHolderName(addCreditCardInformationRequest.getCardHolderName());
        creditCardInformation.setCardExpirationMonth(addCreditCardInformationRequest.getCardExpirationMonth());
        creditCardInformation.setCreditCardNumber(addCreditCardInformationRequest.getCreditCardNumber());
        creditCardInformation.setCardExpirationYear(addCreditCardInformationRequest.getCardExpirationYear());
        creditCardInformation.setCardType(addCreditCardInformationRequest.getCardType());
        creditCardInformationRepository.save(creditCardInformation);

        AddCreditCardInformationResponse addCreditCardInformationResponse = new AddCreditCardInformationResponse();
        addCreditCardInformationResponse.setMessage("Credit card information successfully added");
        return addCreditCardInformationResponse;
    }


    @Override
    public RemoveCreditCardInformationResponse removeCreditCardInformation(RemoveCreditCardInformationRequest removeCreditCardInformationRequest){
        RemoveCreditCardInformationResponse removeCreditCardInformationResponse = new RemoveCreditCardInformationResponse();
        List<CreditCardInformation> creditCardInformationList = creditCardInformationRepository.findAll();
        for (CreditCardInformation creditCard : creditCardInformationList) {
            if (Objects.equals(creditCard.getCreditCardNumber(), removeCreditCardInformationRequest.getCreditCardNumber())){
                creditCardInformationRepository.delete(creditCard);
                removeCreditCardInformationResponse.setMessage("Credit card information successfully deleted");
            }else {
                throw new IllegalArgumentException("Wrong credit card information, try again");
            }
        }
        return removeCreditCardInformationResponse;
    }

    @Override
    public ModifyCreditCardInformationResponse modifyCreditCard(ModifyCreditCardInformationRequest modifyCreditCardInformationRequest) {
        ModifyCreditCardInformationResponse modifyCreditCardResponse = new ModifyCreditCardInformationResponse();
        List<CreditCardInformation> creditCardList = creditCardInformationRepository.findAll();
        for (CreditCardInformation creditCard : creditCardList) {
            if (Objects.equals(creditCard.getCreditCardNumber(), modifyCreditCardInformationRequest.getCreditCardNumber())) {
                creditCard.setCreditCardNumber(modifyCreditCardInformationRequest.getCreditCardNumber());
                creditCard.setCardCVV(modifyCreditCardInformationRequest.getCardCVV());
                creditCard.setCardHolderName(modifyCreditCardInformationRequest.getCardHolderName());
                creditCard.setCardExpirationMonth(modifyCreditCardInformationRequest.getCardExpirationMonth());
                creditCard.setCardExpirationYear(modifyCreditCardInformationRequest.getCardExpirationYear());
                creditCard.setCardType(modifyCreditCardInformationRequest.getCardType());
                creditCardInformationRepository.save(creditCard);
                modifyCreditCardResponse.setMessage("Credit card information successfully updated");
            }else {
                throw new IllegalArgumentException("Incorrect Card Information, try again");
            }
        }
        return modifyCreditCardResponse;
    }

    @Override
    public List<CreditCardInformation> getCreditCardInformation() {
        return creditCardInformationRepository.findAll();
    }

}
