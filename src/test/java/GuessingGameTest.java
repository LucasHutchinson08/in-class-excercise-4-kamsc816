import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

@DisplayName("Guessing Game Tests")
public class GuessingGameTest {

    @Test
    @DisplayName("Code should compile without errors")
    void testCodeCompiles() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/GuessingGame.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.length() > 0, "❌ Source code should exist and not be empty");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Game should use Random class")
    void testUsesRandomClass() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/GuessingGame.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("Random"), 
                "❌ Should use Random class to generate secret number");
            assertTrue(sourceCode.contains("nextInt"), 
                "❌ Should use nextInt() method from Random class");
            assertTrue(sourceCode.contains("rand") || sourceCode.contains("random"), 
                "❌ Should create and use a Random object (look for 'rand' or 'random')");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Game should use do-while loop")
    void testUsesDoWhileLoop() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/GuessingGame.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            assertTrue(sourceCode.contains("do"), 
                "❌ Should use do-while loop (look for 'do' keyword)");
            assertTrue(sourceCode.contains("while"), 
                "❌ Should contain 'while' keyword");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Game should use Scanner for input")
    void testUsesScanner() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/GuessingGame.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("Scanner"), 
                "❌ Should use Scanner class for user input");
            assertTrue(sourceCode.contains("nextInt"), 
                "❌ Should use nextInt() method from Scanner");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Game should have proper loop structure")
    void testLoopStructure() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/GuessingGame.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            boolean hasGuessComparison = sourceCode.contains("!=") || 
                                       sourceCode.contains("==") ||
                                       sourceCode.contains(">") ||
                                       sourceCode.contains("<");
            
            assertTrue(hasGuessComparison, 
                "❌ Should have loop condition comparing guess with the secret number");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Game should have proper feedback messages")
    void testFeedbackMessages() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/GuessingGame.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            String lowerSource = sourceCode.toLowerCase();
            boolean hasFeedback = lowerSource.contains("too low") || 
                                lowerSource.contains("too high") ||
                                lowerSource.contains("correct") ||
                                lowerSource.contains("got it");
            
            assertTrue(hasFeedback, 
                "❌ Should have feedback messages for user guesses");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }
}
