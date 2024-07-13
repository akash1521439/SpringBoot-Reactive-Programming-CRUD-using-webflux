package com.example.springReactive.service;

import com.example.springReactive.model.Invoice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvoiceService {

	public Mono<Invoice> saveInvoice(Invoice invoice);
	
	public Flux<Invoice> findAllInvoices();
	
	public Mono<Invoice> getOneInvoice(Integer id);
	
	public Mono<Void> deleteInvoice(Integer id);
}
