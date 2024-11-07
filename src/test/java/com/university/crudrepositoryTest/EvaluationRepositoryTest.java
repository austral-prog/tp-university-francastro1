package com.university.crudrepositoryTest;

import com.university.crudrepository.EvaluationRepository;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.WrittenExam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

class EvaluationRepositoryTest {
    private EvaluationRepository evaluationRepo;
    private WrittenExam evaluation;

    @BeforeEach
    public void setup() {
        evaluationRepo = new EvaluationRepository();
        evaluation = new WrittenExam("Parcial", "John Doe", "Math", "WRITTEN_EXAM");
    }

    @Test
    void testDelete() {
        evaluationRepo.create(evaluation);
        evaluationRepo.delete(1);

        Evaluation deleted = evaluationRepo.read(1);
        assertNull(deleted);
    }

    @Test
    void testGetIdentifier() {
        assertEquals("Evaluation", evaluationRepo.getIdentifier());
    }

    @Test
    void testGetEntityClass() {
        assertEquals(Evaluation.class, evaluationRepo.getEntityClass());
    }
}

