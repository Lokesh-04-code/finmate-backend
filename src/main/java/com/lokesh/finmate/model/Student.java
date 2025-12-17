package com.lokesh.finmate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private String id;

    private String username;
    private String email;
    private String password;

    private String currency = "INR";
    private double budget = 0;

    private Categories categories = new Categories();

    private long createdAt = System.currentTimeMillis();
    private long updatedAt = System.currentTimeMillis();
}
