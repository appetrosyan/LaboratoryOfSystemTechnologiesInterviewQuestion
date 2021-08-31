import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class VarByteSerialiser {
    public static byte[] serialise(int[] thingToSerialise){
        char[] out = new char[thingToSerialise.length];
        for (int i=0; i< thingToSerialise.length; ++i){
            out[i] = (char) thingToSerialise[i]; // Никогда не 0, Значит можно использовать в FFI.
        }
        return new String(out).getBytes(StandardCharsets.UTF_8);
    }

    public static int[] deserialise(byte[] thingToDeserialise){
        String buffer= new String(thingToDeserialise, StandardCharsets.UTF_8);
        char[] out =  buffer.toCharArray();
        int[] retval = new int[buffer.length()];
//        Нельзя использовать out.length, т.к. UTF-8 Вариабильная кодировка.
        for (int i = 0; i < out.length; i++) {
            retval[i] = (int) out[i];
//            16-bit signed int only.
        }
        return retval;
    }
}
