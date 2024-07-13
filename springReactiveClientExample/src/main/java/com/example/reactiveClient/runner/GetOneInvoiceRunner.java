package com.example.reactiveClient.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.reactiveClient.model.Invoice;

import reactor.core.publisher.Mono;

@Component
public class GetOneInvoiceRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create("http://localhost:8080");
		
		Mono<Invoice> mono = client.get()
				.uri("/invoice/get/2")
				.retrieve()
				.bodyToMono(Invoice.class);
		mono.subscribe(System.out::println);
						
		
	}

}
