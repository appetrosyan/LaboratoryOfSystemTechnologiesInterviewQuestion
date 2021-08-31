import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DeltaEncoderTest {
    @Test
    void encodingZerosReturnsZeros() {
        int[] testResult = DeltaEncoder.encode(testZeros).getEncodedRepresentation();
        assertArrayEquals(testZeros, testResult);
    }

    int[] testZeros = new int[20];
    int[] testOnes = {1, 1, 1, 1, 1, 1};
    int[] testArithmeticSequence = {1, 2, 3, 4, 5, 6};

    @Test
    void decodeIsInverseOfEncode() {
        DeltaEncoder testResult = DeltaEncoder.encode(testZeros);
        assertArrayEquals(testZeros, testResult.decode());
        testResult = DeltaEncoder.encode(testOnes);
        assertArrayEquals(testOnes, testResult.decode());
        testResult = DeltaEncoder.encode(testArithmeticSequence);
        assertArrayEquals(testArithmeticSequence, testResult.decode());
    }
}