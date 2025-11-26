package com.mutantes.mutant_detector.service;

import com.mutantes.mutant_detector.entity.DnaRecord;
import com.mutantes.mutant_detector.mutantLogic.MutantDetector;
import com.mutantes.mutant_detector.repository.DnaRecordRepository;
import com.mutantes.mutant_detector.util.DnaHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MutantServiceImpl implements MutantService {
    private final MutantDetector detector;
    private final DnaRecordRepository repository;

    @Override
    public boolean isMutant(String[] dna) {
        String hash = DnaHasher.sha256(dna);

        return repository.findByDnaHash(hash)
                .map(record -> record.isMutant())   // cache hit
                .orElseGet(() -> {
                    boolean result = detector.isMutant(dna);
                    repository.save(new DnaRecord(hash, result));
                    return result;
                });
    }


}
