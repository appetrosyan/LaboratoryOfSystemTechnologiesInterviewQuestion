import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RunLengthEncodedTest {
    int[] testZeros = new int[20];
    int[] testOnes = {1, 1, 1, 1, 1, 1};
    int[] testArithmeticSequence = {1, 2, 3, 4, 5, 6};

    @Test
    void decodeIsInverseOfEncode() {
        RunLengthEncoder testResult = RunLengthEncoder.encode(testZeros);
        assert(Arrays.equals(testZeros, testResult.decode()));
        testResult = RunLengthEncoder.encode(testOnes);
        assert(Arrays.equals(testOnes, testResult.decode()));
        testResult = RunLengthEncoder.encode(testArithmeticSequence);
        assert(Arrays.equals(testArithmeticSequence, testResult.decode()));
    }
}