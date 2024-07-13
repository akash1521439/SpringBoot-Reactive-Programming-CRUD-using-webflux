package com.example.springReactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springReactive.model.Invoice;
import com.example.springReactive.service.InvoiceService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService service;
	
	@PostMapping("/save")
	public Mono<Invoice> saveOneInvoice(@RequestBody Invoice invoice){
		return service.saveInvoice(invoice);
	}
	
	@GetMapping("/allInvoices")
	public Flux<Invoice> getAllInvoices(){
		return service.findAllInvoices();
	}
	
	@GetMapping("/get/{id}")
	public Mono<Invoice> getOneInvoice(@PathVariable Integer id){
		Mono<Invoice> invoice= service.getOneInvoice(id);
		return invoice;
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<String> deleteInvoice(@PathVariable Integer id){
		service.deleteInvoice(id);
		return Mono.just("Invoice with id: " +id+ " deleted !");
	}
}
