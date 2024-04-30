package com.lucete.comprehensive.purchase.purchase;

import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.product.model.service.ProductService;
import com.lucete.comprehensive.user.member.MemberDTO;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductService productService;

    @GetMapping("/payment/kakaoPay")
    public String getKakaoPay(Model model, int prodSerial) {

        System.out.println();

        ProductDTO productDTO = productService.payment(prodSerial);

        ProductDTO productDTO1 = productService.paymentData(prodSerial);

        model.addAttribute("product", productDTO);
        model.addAttribute("productDTO", productDTO1);

        return "payment/kakaoPay";
    }
}
