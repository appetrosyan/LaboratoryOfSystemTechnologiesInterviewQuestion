import java.util.Arrays;

public class ConstByteSerialiser {
    public static String serialise (int[] thingToSerialise){
//        Технически в Java, все строки кодированы в UTF-16, потому чтобы строки можно было бы использовать
//        как строки, придётся пожервтовать компактностью.
        char[] out = new char[thingToSerialise.length];
//        16 битные char-ы могут удержать числа до 32766 > 1000, естественно если нужны будут 32-х битные представления,
//        то их можно разбить пополам и закодировать в двух char-ах. В Вариабильной кодировке UTF-8 это несущественно.
        for (int i=0; i< thingToSerialise.length; ++i){
            out[i] = (char) thingToSerialise[i]; // Which is never 0, meaning the string is safely usable for C interop.
        }
        return new String(out);
    }

    public static int[] deserialise (String thingtoDeserialise){
        char[] out = thingtoDeserialise.toCharArray();
        int[] retval = new int[thingtoDeserialise.length()];
//        Нельзя использовать out.length, т.к. UTF-8 Вариабильная кодировка.
        for (int i = 0; i < out.length; i++) {
            retval[i] = (int) out[i];
//            16-bit signed int only.
        }
        return retval;
    }

}
