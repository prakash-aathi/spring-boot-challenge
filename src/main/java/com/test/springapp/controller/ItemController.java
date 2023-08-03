package com.test.springapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springapp.model.Item;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    
    private List<Item> itemStore = new ArrayList<>();
    private int nextItemId = 1;

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody Item newItem) {

        // checking the fields are not null or empty
        if (newItem.getName() == null || newItem.getName().isEmpty() ||
            newItem.getDescription() == null || newItem.getDescription().isEmpty()) {
            return ResponseEntity.badRequest().body("Name and description are required.");
        }

        // just assigning an ID to the item we not using any database auto Increment
        newItem.setId(nextItemId++);
        itemStore.add(newItem);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {

        // checking the fields are not null or empty
        Optional<Item> item = itemStore.stream().filter(i -> i.getId() == id).findFirst();
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
