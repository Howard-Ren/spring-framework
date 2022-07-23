package annotation;

import org.assertj.core.api.Assertions;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * @author rhx
 * @date 2022/5/7 9:49
 **/
@MyService
public class Test {

	@org.junit.jupiter.api.Test
	public void test1() throws IOException {
		final MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(Test.class.getName());
		final AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		final Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
		Assertions.assertThat(annotationTypes).singleElement().isEqualTo("annotation.MyService");
		for (String annotationType : annotationTypes) {
			final Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
			Assertions.assertThat(metaAnnotationTypes).hasSizeGreaterThan(1)
					.contains("org.springframework.stereotype.Service")
					.contains("org.springframework.stereotype.Component");
		}
	}

}
