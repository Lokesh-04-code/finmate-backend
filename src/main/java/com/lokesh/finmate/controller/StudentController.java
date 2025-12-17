package com.lokesh.finmate.controller;

import com.lokesh.finmate.model.BudgetUpdateRequest;
import com.lokesh.finmate.model.Student;
import com.lokesh.finmate.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Student s) {
        return ResponseEntity.ok(service.register(s));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String token = service.login(body.get("email"), body.get("password"));

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "token", token
        ));
    }

    @GetMapping("/current")
    public ResponseEntity<?> current(HttpServletRequest req) {
        System.out.print("i got request");
        String userId = (String) req.getAttribute("userId");
        return ResponseEntity.ok(service.getCurrent(userId));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            HttpServletRequest req,
            @RequestBody BudgetUpdateRequest update
    ) {
        String userId = (String) req.getAttribute("userId");
        System.out.println(update);
        return ResponseEntity.ok(service.updateBudget(userId, update));
    }


}

