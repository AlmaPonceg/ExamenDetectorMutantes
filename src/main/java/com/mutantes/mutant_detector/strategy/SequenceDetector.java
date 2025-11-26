package com.mutantes.mutant_detector.strategy;

public interface SequenceDetector {
    boolean detect (char[][] matrix, int row, int col);
    String name();
}
