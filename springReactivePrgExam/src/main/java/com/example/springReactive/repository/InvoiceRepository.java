package com.example.springReactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.springReactive.model.Invoice;

public interface InvoiceRepository extends ReactiveMongoRepository<Invoice,Integer>{

}
