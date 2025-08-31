package com.example.ecommerce;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class ArchitectureTest
{
    @Test
    void domainClassesShouldNotDependOnApplicationLayer() {
        String packageName = SimpleGreetResource.class.getPackageName();
        JavaClasses importedClasses = new ClassFileImporter().importPackages(packageName);

        ArchRuleDefinition.noClasses()
                .that().resideInAPackage(packageName)
                .should().dependOnClassesThat().resideInAPackage("..application..")
                .check(importedClasses);
    }
}
