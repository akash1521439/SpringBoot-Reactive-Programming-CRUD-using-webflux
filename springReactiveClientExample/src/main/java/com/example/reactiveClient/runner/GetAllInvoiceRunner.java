package com.example.reactiveClient.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.reactiveClient.model.Invoice;

import reactor.core.publisher.Flux;

@Component
public class GetAllInvoiceRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		WebClient client = WebClient.create("http://localhost:8080");
		Flux<Invoice> flux = client.get().uri("/invoice/allInvoices")
						.retrieve().bodyToFlux(Invoice.class);
		flux.doOnNext(System.out::println).blockLast();
		
	}

}
