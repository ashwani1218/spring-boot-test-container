package com.ashwani.testcontainer;

import com.ashwani.testcontainer.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.datasource.url=jdbc:tc:mysql:5.7.34:///")
@AutoConfigureWebClient
class TestBookCatalogApplication{

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void addBookToCatalog() {
		var bookToCreate = new Book(null, "The Alchemist");

		webTestClient
				.post()
				.uri("/book")
				.bodyValue(bookToCreate)
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody(Book.class).value(actualBook ->{
					assertThat(actualBook.id ()).isNotNull();
					assertThat(actualBook.title()).isEqualTo(bookToCreate.title());
			});
	}

}
