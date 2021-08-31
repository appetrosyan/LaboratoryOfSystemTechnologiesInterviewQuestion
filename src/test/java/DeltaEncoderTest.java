import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DeltaEncoderTest {
    @Test
    void encodingZerosReturnsZeros() {
        int[] testResult = DeltaEncoder.encode(testZeros).getEncodedRepresentation();
        assert(Arrays.equals(testZeros, testResult));
    }

    int[] testZeros = new int[20];
    int[] testOnes = {1, 1, 1, 1, 1, 1};
    int[] testArithmeticSequence = {1, 2, 3, 4, 5, 6};

    @Test
    void decodeIsInverseOfEncode() {
        DeltaEncoder testResult = DeltaEncoder.encode(testZeros);
        assert(Arrays.equals(testZeros, testResult.decode()));
        testResult = DeltaEncoder.encode(testOnes);
        assert(Arrays.equals(testOnes, testResult.decode()));
        testResult = DeltaEncoder.encode(testArithmeticSequence);
        assert(Arrays.equals(testArithmeticSequence, testResult.decode()));
    }
};