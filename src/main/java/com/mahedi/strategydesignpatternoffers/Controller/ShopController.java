package com.mahedi.strategydesignpatternoffers.Controller;

import com.mahedi.strategydesignpatternoffers.enums.OfferType;
import com.mahedi.strategydesignpatternoffers.model.Shop;
import com.mahedi.strategydesignpatternoffers.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ShopController {
private final ShopService shopService;

    @PostMapping("/offer/save-all")
    public String saveAllAccess(@ModelAttribute Shop shop) {
        shop.setId(1L);
        shopService.saveOffer(shop);
        return "redirect:/settings/access/control";
    }

    @GetMapping("/enum-page")
    public String enumPage(Model model) {
        OfferType[] offerTypes = OfferType.values();
        model.addAttribute("offerTypes", offerTypes);
//        Long shopId = 1L; // Replace 1L with the actual id of the shop you want to retrieve
//        Shop existingShop = shopService.getShopById(shopId);
//        if (existingShop != null) {
//            model.addAttribute("shop", existingShop);
//        } else {
//            model.addAttribute("shop", new Shop());
//        }

        Shop shop = shopService.getShopById(1L);
//        String shop1 = shopService.getShopByDiscount("offerTypes");
        if (shop == null) {
            shop = new Shop();
            shop.setId(1L);
        }
        model.addAttribute("shop", shop);

        return "enumPage";
    }


}
