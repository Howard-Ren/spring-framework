package org.springframework.context.annotation;

import annotation.MyController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * @author rhx
 * @date 2022/5/7 10:17
 **/
public class ConfigurationTest {

	@Test
	public void test1() throws IOException {
		final MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(MyController.class.getName());
		final AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		final boolean configurationCandidate = ConfigurationClassUtils.isConfigurationCandidate(annotationMetadata);
		Assertions.assertTrue(configurationCandidate);
	}

	@Test
	public void test2() throws IOException {
		final MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(ClassWithBean.class.getName());
		final AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		final boolean configurationCandidate = ConfigurationClassUtils.isConfigurationCandidate(annotationMetadata);
		Assertions.assertTrue(configurationCandidate);
	}
}
