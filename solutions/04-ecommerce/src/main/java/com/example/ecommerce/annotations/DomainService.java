package com.example.ecommerce.annotations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import org.jmolecules.architecture.layered.DomainLayer;
import org.jvnet.hk2.annotations.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Marks a class as a Domain Service in the DDD sense.
 * <p>
 * A Domain Service encapsulates business logic that does not naturally belong
 * to an Entity or Value Object but is still part of the core domain. Examples
 * include calculations, policies, or operations that involve multiple
 * aggregates. Domain Services are stateless and focus only on expressing
 * domain rules, not infrastructure or orchestration.
 * </p>
 */
@Stereotype
@ApplicationScoped
@Inherited
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@Service
@DomainLayer
public @interface DomainService {
}
