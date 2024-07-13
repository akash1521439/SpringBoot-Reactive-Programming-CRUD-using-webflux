package com.example.reactiveClient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Invoice {
    
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String number;
	@NonNull
	private Double amount;
}