package com.example.ecommerce.annotations;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import org.jmolecules.architecture.layered.DomainLayer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Marks a class as a Repository in the DDD sense.
 * <p>
 * A Repository provides controlled access to aggregates, acting as a bridge
 * between the domain and the persistence mechanism. It hides storage details
 * and exposes only intent-driven operations, ensuring the domain layer remains
 * persistence-agnostic. Repositories should return aggregates or value objects,
 * never database records.
 * </p>
 */
@Stereotype
@ApplicationScoped
@Inherited
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@DomainLayer
public @interface Repository {
}