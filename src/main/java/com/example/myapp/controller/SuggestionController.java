package com.example.myapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/suggestions")
@CrossOrigin(origins = "*") // allow React to call
public class SuggestionController {

    @GetMapping
    public List<Map<String, Object>> getSuggestions(
            @RequestParam String name,
            @RequestParam double price) {

        // Mock product suggestions (later replace with Amazon/Flipkart API calls)
        List<Map<String, Object>> suggestions = new ArrayList<>();

        Map<String, Object> product1 = new HashMap<>();
        product1.put("title", name + " Pro Edition");
        product1.put("price", price + 100);
        product1.put("link", "https://www.amazon.com/example-product-1");
        suggestions.add(product1);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("title", name + " Budget Edition");
        product2.put("price", price - 50);
        product2.put("link", "https://www.flipkart.com/example-product-2");
        suggestions.add(product2);

        return suggestions;
    }
}
