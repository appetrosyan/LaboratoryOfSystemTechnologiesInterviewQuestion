import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class DeltaEncoder implements IEncoded{
    private final int[] encodedRepresentation;

    DeltaEncoder(int[] encodedArray){
        encodedRepresentation = encodedArray;
    }

    @NotNull
    @Contract(value = "_ -> new", pure = true)
    public static DeltaEncoder encode(int @NotNull [] array){
        int previous = array[0];
        int[] out = new int[array.length];
        out[0] = previous;
        for (int i = 1; i < array.length; i++) {
            out[i] = array[i] - previous;
            previous = array[i];
        }
        return new DeltaEncoder(out);
    }

    @Contract(value = " -> new", pure = true)
    @Override
    public int @NotNull [] decode() {
        int previous = encodedRepresentation[0];
        int[] out = new int[encodedRepresentation.length];
        out[0] = previous;
        for (int i = 1; i < encodedRepresentation.length; i++) {
            out[i] = previous + encodedRepresentation[i];
            previous = out[i];
        }
        return out;
    }

    @Override
    public int[] getEncodedRepresentation() {
        return this.encodedRepresentation;
    }
}
