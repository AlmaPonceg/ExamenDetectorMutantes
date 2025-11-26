package com.mutantes.mutant_detector.validator;


import com.mutantes.mutant_detector.exception.InvalidDnaException;

public class SquareMatrizValidator implements DnaValidator {
    public void check(String[] dna) {
        int n = dna.length;
        for (String row : dna) {
            if (row.length() != n) {
                throw new InvalidDnaException("Matriz debe ser NxN");
            }
        }
    }
}
