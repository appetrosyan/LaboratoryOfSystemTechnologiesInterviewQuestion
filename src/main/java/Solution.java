import java.util.Arrays;

public class Solution {
    public static byte[] serialiseAndEncode(int[] input){
        int[] _input = input.clone();
        // Сортируем.  Порядок не важен, потому это удобнее.
        Arrays.sort(_input);
        _input = DeltaEncoder.encode(_input).getEncodedRepresentation();
        // Это уменьшит значение почти всех чисел, что облегчит дело для сериализации.

//        _input = RunLengthEncoded.encode(_input).getEncodedRepresentation();
        // Это имеет смысл делать если длина массива больше чем количество допустимых значений. В нашем случае если их
        // больше 2к. Для того чтобы это использовать придётся пожертвовать ещё одним байтом, чтобы записать тип кодировки
        return VarByteSerialiser.serialise(_input);
//        Написать в файл и готово.
    }

    public static int[] deserialiseAndDecode(byte[] input){
        return new DeltaEncoder(VarByteSerialiser.deserialise(input)).decode();
    }
}
