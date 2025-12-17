package com.lokesh.finmate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("transactions")
public class Transaction {

    @Id
    private String id;

    private String userId;
    private String title;
    private double amount;
    private String type;
    private String category;
    private boolean isRecurring;

    // 👇 equivalent of Date.now in Express
    @CreatedDate
    private LocalDateTime date;
}
