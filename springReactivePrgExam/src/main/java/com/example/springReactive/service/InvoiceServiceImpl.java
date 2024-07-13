package com.example.springReactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springReactive.model.Invoice;
import com.example.springReactive.repository.InvoiceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InvoiceRepository repo;
	

	@Override
	public Mono<Invoice> saveInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return repo.save(invoice);
	}

	@Override
	public Flux<Invoice> findAllInvoices() {
		// TODO Auto-generated method stub
		return repo.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Invoice> getOneInvoice(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> deleteInvoice(Integer id) {
		// TODO Auto-generated method stub
		return repo.deleteById(id);
	}

}
