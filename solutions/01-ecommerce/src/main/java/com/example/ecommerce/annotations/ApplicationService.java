package com.example.ecommerce.annotations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Marks a class as an Application Service in the DDD sense.
 * <p>
 * Application Services coordinate use cases by invoking domain objects and
 * repositories. They handle transactions, orchestration, and security, but do
 * not contain business rules themselves. Their role is to expose the domain
 * model to the outside world while keeping the domain layer pure.
 * </p>
 */
@Stereotype
@ApplicationScoped
@Inherited
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ApplicationService {
}
