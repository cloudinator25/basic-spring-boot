package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
public class HelloController {

    public List<Map<String, String>> items = new ArrayList<>();
    private int idCounter = 1;

    @PostMapping
    public ResponseEntity<Map<String, String>> createItem(@RequestBody Map<String, String> newItem){
        newItem.put("id", String.valueOf(idCounter++));
        items.add(newItem);
        Map<String, String> response = new HashMap<>();
        response.put("message","Item created successfully!!!");
        response.put("item", newItem.toString());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> getAllItems(){
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
