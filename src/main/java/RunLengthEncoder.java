import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class RunLengthEncoder implements IEncoded{
    public ArrayList<Integer> getValues() {
        return values;
    }

    public ArrayList<Integer> getOccurrences() {
        return occurrences;
    }

    public int getOriginalSize() {
        return originalSize;
    }

    private final ArrayList<Integer>  values;
    private final ArrayList<Integer> occurrences;
    private final int originalSize;

    RunLengthEncoder(@NotNull ArrayList<Integer> values, @NotNull ArrayList<Integer> occurrences, int originalSize){
        this.values = values;
        this.occurrences = occurrences;
        assert(values.size() == occurrences.size());
        this.originalSize = originalSize;
    }

    @Contract("_ -> new")
    public static @NotNull RunLengthEncoder encode(int @NotNull [] unencodedData){
        int previous = unencodedData[0], cursor = 0;
        ArrayList<Integer> values=new ArrayList<>(unencodedData.length), occurrences = new ArrayList<>(unencodedData.length);
        values.set(cursor, unencodedData[0]);
        occurrences.set(cursor, 1);
        for (int i = 1; i < unencodedData.length; ++i) {
            if (unencodedData[i] == previous){
                occurrences.set(cursor, occurrences.get(cursor) +1);
            } else {
                cursor++;
                values.set(cursor, unencodedData[i]);
                occurrences.set(cursor, 1);
                previous = unencodedData[i];
            }
        }
        values.trimToSize();
        occurrences.trimToSize();
        return new RunLengthEncoder( values,  occurrences, unencodedData.length);
    }

    @Override
    public int @NotNull [] decode() {
        int[] out = new int[originalSize];
        int cursor = 0;
        for(int i=0; i<values.size(); ++i){
            for(int j=0; j< occurrences.get(i); ++j){
                out[cursor] =  values.get(i);
            }
        }
        return out;
    }

    @Override
    public int @NotNull [] getEncodedRepresentation(){
        int[] out = new int[values.size() + occurrences.size()];
        for (int i = 0; i < values.size() + occurrences.size(); i+=2) {
            out[i] = values.get(i);
            out[i+1] = occurrences.get(i);
        }
        return out;
    }
}
