import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Shopping Cart Tests")
public class ShoppingCartTest {

    private String runWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes);

        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;
        try {
            System.setIn(in);
            System.setOut(out);
            ShoppingCart.main(new String[]{});
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
        return outBytes.toString(StandardCharsets.UTF_8);
    }

    @Test
    @DisplayName("Code should compile without errors")
    void testCodeCompiles() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/ShoppingCart.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.length() > 0, "❌ Source code should exist and not be empty");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should use Scanner for input")
    void testUsesScanner() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/ShoppingCart.java").toPath(), 
                StandardCharsets.UTF_8
            );
            assertTrue(sourceCode.contains("Scanner"), 
                "❌ Should use Scanner class for user input");
            assertTrue(sourceCode.contains("nextInt") || sourceCode.contains("nextDouble"), 
                "❌ Should use nextInt() or nextDouble() method from Scanner");
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should use for loop")
    void testUsesForLoop() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/ShoppingCart.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            assertTrue(sourceCode.contains("for"), 
                "❌ Should use for loop to iterate through items");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have proper loop structure")
    void testLoopStructure() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/ShoppingCart.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            boolean hasLoopStructure = sourceCode.contains("++") || 
                                    sourceCode.contains("+=") ||
                                    sourceCode.contains("+ 1");
            
            assertTrue(hasLoopStructure, 
                "❌ Should have proper loop increment (i++ or similar)");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should calculate total cost")
    void testCalculatesTotal() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/ShoppingCart.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            boolean hasTotalCalculation = sourceCode.contains("+=") || 
                                        sourceCode.contains("+") ||
                                        sourceCode.contains("total +");
            
            assertTrue(hasTotalCalculation, 
                "❌ Should calculate total cost by adding prices");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have proper output format")
    void testOutputFormat() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/ShoppingCart.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            String lowerSource = sourceCode.toLowerCase();
            boolean hasOutputMessages = lowerSource.contains("how") || 
                                      lowerSource.contains("price") ||
                                      lowerSource.contains("cart") ||
                                      lowerSource.contains("total");
            
            assertTrue(hasOutputMessages, 
                "❌ Should have proper output messages for user interaction");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Should use double for prices")
    void testUsesDoubleForPrices() {
        try {
            String sourceCode = Files.readString(
                new File("src/main/java/ShoppingCart.java").toPath(), 
                StandardCharsets.UTF_8
            );
            
            boolean usesDouble = sourceCode.contains("double") || 
                               sourceCode.contains("nextDouble");
            
            assertTrue(usesDouble, 
                "❌ Should use double data type for prices (decimal numbers)");
                
        } catch (Exception e) {
            fail("❌ Could not read source code: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Example input produces expected total and messages")
    void testExampleIO() {
        String output = runWithInput("3\n1.5\n3.1\n0.5\n");

        String lower = output.toLowerCase();
        assertTrue(lower.contains("how"),
            "❌ Should prompt for number of items. Output: " + output);
        assertTrue(lower.contains("price of item"),
            "❌ Should prompt for each item price. Output: " + output);

        // Final total
        assertTrue(output.contains("3"),
            "❌ Final summary should include item count. Output: " + output);
        assertTrue(output.contains("$5.1"),
            "❌ Expected total to be $5.1. Output: " + output);
    }
}
