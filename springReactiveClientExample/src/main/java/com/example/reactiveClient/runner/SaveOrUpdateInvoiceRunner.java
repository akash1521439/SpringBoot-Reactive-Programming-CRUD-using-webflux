package com.example.reactiveClient.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.reactiveClient.model.Invoice;

import reactor.core.publisher.Mono;

@Component
public class SaveOrUpdateInvoiceRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create("http://localhost:8080");
		Mono<Invoice> mono = client.post().uri("/invoice/save")
					.body(Mono.just(new Invoice(1,"invo1","Import",13.8)), Invoice.class)
					.retrieve().bodyToMono(Invoice.class);
		mono.subscribe(System.out::println);
	}

}
