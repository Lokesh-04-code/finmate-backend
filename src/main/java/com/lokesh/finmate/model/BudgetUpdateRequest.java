package com.lokesh.finmate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class BudgetUpdateRequest {
    private double budget;
    private Categories categories;
}

