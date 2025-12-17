package com.lokesh.finmate.controller;

import com.lokesh.finmate.model.Transaction;
import com.lokesh.finmate.service.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<?> create(HttpServletRequest req, @RequestBody Transaction t) {
        String userId = (String) req.getAttribute("userId");
        return ResponseEntity.ok(service.create(userId, t));
    }

    @GetMapping
    public ResponseEntity<?> getAll(HttpServletRequest req) {
        String userId = (String) req.getAttribute("userId");
        return ResponseEntity.ok(service.getAll(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(HttpServletRequest req, @PathVariable String id) {
        String userId = (String) req.getAttribute("userId");
        return ResponseEntity.ok(service.getById(id, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(HttpServletRequest req,
                                    @PathVariable String id,
                                    @RequestBody Transaction t) {
        String userId = (String) req.getAttribute("userId");
        return ResponseEntity.ok(service.update(id, userId, t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(HttpServletRequest req, @PathVariable String id) {
        String userId = (String) req.getAttribute("userId");
        service.delete(id, userId);
        return ResponseEntity.ok(Map.of("status", "deleted"));
    }
}
