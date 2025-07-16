package com.sweetshop.controller;

import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    @PostMapping
    public Sweet addSweet(@RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }

    @PutMapping("/{id}")
    public Sweet updateSweet(@PathVariable Long id, @RequestParam int quantity) {
        return sweetService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
    }
}
