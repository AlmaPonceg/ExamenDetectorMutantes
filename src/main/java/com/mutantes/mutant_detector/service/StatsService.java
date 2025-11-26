package com.mutantes.mutant_detector.service;

import com.mutantes.mutant_detector.DTO.StatsResponse;


public interface StatsService {
    long getMutantCount();
    long getHumanCount();

    StatsResponse getStats();   // <-- agregue esto nada mas como mejora
}