package org.adligo.tests4j_4gwt.client.model.example;

import java.util.Set;

import org.adligo.tests4j.models.shared.common.Platform;
import org.adligo.tests4j.models.shared.dependency.GWT_2_6_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.PlatformType;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.TargetedPlatform;
import org.adligo.tests4j.models.shared.trials.Test;

/**
 * in actual usage this class would 
 * be auto generated for each 
 * @author scott
 *
 */
@SourceFileScope (sourceClass=GWT_2_6_DependencyGroup.class)
@TargetedPlatform ({
	@PlatformType (platform=Platform.GWTC),
	@PlatformType (platform=Platform.JSE)
})
public class ExampleGwtTrial extends SourceFileTrial {
	@Test
	public void testJavaLang() {
		Set<Class<?>> javaLangClasses =  GWT_2_6_DependencyGroup.JAVA_LANG;
		for (Class<?> c: javaLangClasses) {
			assertNotNull(c);
			assertNotNull(c.hashCode());
		}
	}
	
	@Test
	public void testJavaAnnotation() {
		Set<Class<?>> javaLangClasses =  GWT_2_6_DependencyGroup.JAVA_ANNOTATION;
		for (Class<?> c: javaLangClasses) {
			assertNotNull(c);
			assertNotNull(c.hashCode());
		}
	}
			
	
	@Test
	public void testJavaMath() {
		Set<Class<?>> javaLangClasses =  GWT_2_6_DependencyGroup.JAVA_MATH;
		for (Class<?> c: javaLangClasses) {
			assertNotNull(c);
			assertNotNull(c.hashCode());
		}
	}
	
	@Test
	public void testJavaIo() {
		Set<Class<?>> javaLangClasses =  GWT_2_6_DependencyGroup.JAVA_IO;
		for (Class<?> c: javaLangClasses) {
			assertNotNull(c);
			assertNotNull(c.hashCode());
		}
	}
	
	@Test
	public void testJavaSql() {
		Set<Class<?>> javaLangClasses =  GWT_2_6_DependencyGroup.JAVA_SQL;
		for (Class<?> c: javaLangClasses) {
			assertNotNull(c);
			assertNotNull(c.hashCode());
		}
	}
	
	@Test
	public void testJavaUtil() {
		Set<Class<?>> javaLangClasses =  GWT_2_6_DependencyGroup.JAVA_UTIL;
		for (Class<?> c: javaLangClasses) {
			assertNotNull(c);
			assertNotNull(c.hashCode());
		}
	}
	
	@Test
	public void testJavaLogging() {
		Set<Class<?>> javaLangClasses =  GWT_2_6_DependencyGroup.JAVA_LOGGING;
		for (Class<?> c: javaLangClasses) {
			assertNotNull(c);
			assertNotNull(c.hashCode());
		}
	}
	

}
