package com.lokesh.finmate.service;

import com.lokesh.finmate.model.Transaction;
import com.lokesh.finmate.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    public Transaction create(String userId, Transaction t) {
        t.setUserId(userId);
        return repo.save(t);
    }

    public List<Transaction> getAll(String userId) {
        return repo.findByUserId(userId);
    }

    public Transaction getById(String id, String userId) {
        Transaction t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        if (!t.getUserId().equals(userId))
            throw new RuntimeException("Not authorized");

        return t;
    }

    public Transaction update(String id, String userId, Transaction data) {

        // 1️⃣ Fetch existing transaction (already correct)
        Transaction t = getById(id, userId);

        // 2️⃣ Update ONLY editable fields

        if (data.getTitle() != null) {
            t.setTitle(data.getTitle());
        }

        if (data.getCategory() != null) {
            t.setCategory(data.getCategory());
        }

        // amount is primitive → always present
        t.setAmount(data.getAmount());

        // 3️⃣ DO NOT update these fields
        // ❌ t.setType(...)
        // ❌ t.setUserId(...)
        // ❌ t.setDate(...)
        // ❌ t.setIsRecurring(...)

        return repo.save(t);
    }


    public void delete(String id, String userId) {
        Transaction t = getById(id, userId);
        repo.delete(t);
    }
}

