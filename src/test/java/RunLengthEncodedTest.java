import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RunLengthEncodedTest {
    int[] testZeros = new int[20];
    int[] testOnes = {1, 1, 1, 1, 1, 1};
    int[] testArithmeticSequence = {1, 2, 3, 4, 5, 6};

    @Test
    void decodeIsInverseOfEncode() {
        RunLengthEncoder testResult = RunLengthEncoder.encode(testZeros);
        assertArrayEquals(testZeros, testResult.decode());
        testResult = RunLengthEncoder.encode(testOnes);
        assertArrayEquals(testOnes, testResult.decode());
        testResult = RunLengthEncoder.encode(testArithmeticSequence);
        assertArrayEquals(testArithmeticSequence, testResult.decode());
    }
}