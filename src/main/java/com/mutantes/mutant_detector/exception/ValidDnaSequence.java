package com.mutantes.mutant_detector.exception;


import com.mutantes.mutant_detector.validator.DnaSequenceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DnaSequenceValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDnaSequence {
    String message() default "El ADN debe ser una matriz NxN (mínimo 4x4) y solo contener A,T,C,G";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

