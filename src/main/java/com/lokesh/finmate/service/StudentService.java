package com.lokesh.finmate.service;

import com.lokesh.finmate.model.BudgetUpdateRequest;
import com.lokesh.finmate.model.Categories;
import com.lokesh.finmate.model.Student;
import com.lokesh.finmate.repository.StudentRepository;
import com.lokesh.finmate.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    public Student register(Student s) {
        if (repo.findByEmail(s.getEmail()).isPresent())
            throw new RuntimeException("Student already exists");

        s.setPassword(new BCryptPasswordEncoder().encode(s.getPassword()));
        return repo.save(s);
    }

    public String login(String email, String password) {
        Student s = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!new BCryptPasswordEncoder().matches(password, s.getPassword()))
            throw new RuntimeException("Invalid credentials");

        return jwtUtil.generateToken(s.getId());
    }

    public Student getCurrent(String userId) {
        return repo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateBudget(String userId, BudgetUpdateRequest update) {
        Student s = getCurrent(userId);
        System.out.println(s);
        System.out.println(update);
        // always update budget
        s.setBudget(update.getBudget());

        if (update.getCategories() != null) {
            s.setCategories(update.getCategories());
        }


        s.setUpdatedAt(System.currentTimeMillis());
        System.out.println(s);
        return repo.save(s);
    }




}
