package com.mahedi.strategydesignpatternoffers.Controller;

import com.mahedi.strategydesignpatternoffers.config.Offerfactory;
import com.mahedi.strategydesignpatternoffers.enums.OfferType;
import com.mahedi.strategydesignpatternoffers.repository.ShopRepository;
import com.mahedi.strategydesignpatternoffers.service.ShopService;
import com.mahedi.strategydesignpatternoffers.strategy.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class ShopRestController {

    private final Offerfactory offerfactory;
    private final ShopService shopService;
    private final ShopRepository shopRepository;


    @GetMapping("/get-offer/{offerType}")
    public String getOfferfromshop(@PathVariable OfferType offerType){
        Offer offer=offerfactory.getOfferfromshop(offerType);
        return offer.getOffer();
    }
    @GetMapping("/shop-by-discount")
    public String getShopByDiscount() {
        // Fetch the offerType from the database using the shopRepository
        String offerTypeString = shopRepository.findByOfferType(OfferType.DISCOUNT);

        // Convert the offerType String to the OfferType enum using OfferType.valueOf()
        OfferType offerTypeEnum = OfferType.valueOf(offerTypeString);

        // Use the Offerfactory to get the corresponding Offer object based on the OfferType
        Offer offerObject = offerfactory.getOfferfromshop(offerTypeEnum);

        // Get the offer details from the offerObject and return it as the response
        return offerObject.getOffer();
    }

    @GetMapping("/get-enum")
    public OfferType[] getEnum(){
        Arrays.stream(OfferType.values())
                .forEach(System.out::println);
        return OfferType.values();
    }
}
