package edu.puj.procesobbva.sor.controller;

import edu.puj.procesobbva.sor.controller.vm.OfferSaveVM;
import edu.puj.procesobbva.sor.domain.Offer;
import edu.puj.procesobbva.sor.domain.Product;
import edu.puj.procesobbva.sor.domain.enumeration.Status;
import edu.puj.procesobbva.sor.repository.OfferRepository;
import edu.puj.procesobbva.sor.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OfferController {
    private final ProductRepository productRepository;
    private final OfferRepository offerRepository;

    public OfferController(ProductRepository productRepository, OfferRepository offerRepository) {
        this.productRepository = productRepository;
        this.offerRepository = offerRepository;
    }

    @PostMapping("/api/offers/create")
    public ResponseEntity<Void> saveOffers(
        @RequestBody OfferSaveVM offers, HttpServletRequest request) throws URISyntaxException {

        List<Product> products = productRepository.findAllByBinIn(offers.getBines());

        List<Offer> offerList = new ArrayList<>();
        products.forEach(product -> {
            Offer offer = new Offer();
            offer.setProductId(product.getId());
            offer.setApplicationId(offers.getApplicationId());
            offer.setQuota(0d);
            offer.setStatus(Status.ACTIVO);

            offerList.add(offer);
        });

        this.offerRepository.saveAll(offerList);

        return ResponseEntity.created(new URI(request.getRequestURI())).build();
    }
}
