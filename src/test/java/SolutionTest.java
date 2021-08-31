import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    int[] testSquares = new int[50];

    SolutionTest(){
        for (int i = 0; i < testSquares.length; i++) {
            testSquares[i] = i*i;
        }
    }

    @Test
    public void testVarByteSerialiseAndDeserialise(){
        byte[] testData = VarByteSerialiser.serialise(testSquares);
        assertArrayEquals(testSquares, VarByteSerialiser.deserialise(testData));
    }
}