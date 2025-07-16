package com.sweetshop.service;

import com.sweetshop.model.Sweet;
import com.sweetshop.repository.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetService {

    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    public Sweet addSweet(Sweet sweet) {
        return sweetRepository.save(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweetRepository.findAll();
    }

    public Sweet updateQuantity(Long id, int quantity) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow();
        sweet.setQuantity(quantity);
        return sweetRepository.save(sweet);
    }

    public void deleteSweet(Long id) {
        sweetRepository.deleteById(id);
    }
}
