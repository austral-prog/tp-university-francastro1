package com.university.cliTest;

import com.university.cli.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        EntityNotFoundException exception = new EntityNotFoundException("Entity not found");
        assertEquals("Entity not found", exception.getMessage());
    }

    @Test
    void testExceptionInheritance() {
        EntityNotFoundException exception = new EntityNotFoundException("Test message");
        assertTrue(exception instanceof RuntimeException);
    }
}

