package com.epam.vshautsova.repository;

import com.epam.vshautsova.entity.Document;
import com.epam.vshautsova.SpringBootFoundationApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test of DocumentRepository.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootFoundationApplication.class)
@ActiveProfiles("dev")
public class DocumentRepositoryTest
{
	@Autowired
	private DocumentRepository documentRepository;

	@Test
	public void testSaveDocumentSuccessful()
	{
		Document document = new Document("hello.docx", "Volha");
		documentRepository.save(document);

		Assertions.assertThat(document.getId()).isNotZero();
		Assertions.assertThat(documentRepository.findById(document.getId())).isNotEmpty();
	}
}
