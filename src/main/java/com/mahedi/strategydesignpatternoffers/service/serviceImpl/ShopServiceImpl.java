package com.mahedi.strategydesignpatternoffers.service.serviceImpl;

import com.mahedi.strategydesignpatternoffers.config.Offerfactory;
import com.mahedi.strategydesignpatternoffers.enums.OfferType;
import com.mahedi.strategydesignpatternoffers.model.Shop;
import com.mahedi.strategydesignpatternoffers.repository.ShopRepository;
import com.mahedi.strategydesignpatternoffers.service.ShopService;
import com.mahedi.strategydesignpatternoffers.strategy.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final Offerfactory offerfactory;

    @Override
    public void saveOffer(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }



    public String getShopByDiscount(String offerType) {

        String offer=shopRepository.findByOfferType(offerType);

        Offer offer1=offerfactory.getOfferfromshop(OfferType.valueOf(offer));


        return offer1.getOffer();
    }


//    public String getShopByDiscount(String offerType) {
//        return shopRepository.findByOfferType(offerType);
//    }
}
