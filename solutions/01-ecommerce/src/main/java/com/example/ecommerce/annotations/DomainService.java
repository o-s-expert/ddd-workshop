package com.example.ecommerce.annotations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Stereotype
@ApplicationScoped
@Inherited
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface DomainService {
}
