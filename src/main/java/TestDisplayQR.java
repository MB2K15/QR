import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;
import org.apache.commons.lang.ArrayUtils;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Matt on 2017-08-05.
 */
public class TestDisplayQR {

    public static void main(String[] args) throws WriterException, IOException, org.json.simple.parser.ParseException {


        ObjectMapper mapper = new ObjectMapper();

        /**
         * Read object from file
         */
        Facebook value = null;
        try {
            value = mapper.readValue(new File("C:\\\\Users\\\\Matt\\\\Desktop\\\\JSF\\\\QR\\\\src\\\\main\\\\resources\\\\f5.json"), Facebook.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String [] arrayTest=value.getPosts().get(1).getMessage().split(" ");
        String [] arrayTest2=value.getPosts().get(0).getMessage().split(" ");
        String [] result = (String[]) ArrayUtils.addAll(arrayTest, arrayTest2);
        String [] resultFinal = value.getPosts().get(2).getMessage().split(" ");
        String [] resultFinals = (String[]) ArrayUtils.addAll(resultFinal,result);

        List <String> listaString = Arrays.asList(resultFinals);
        System.out.println(findMostCommonWords(listaString));

}

    public static Map<String, Long> findMostCommonWords(List <String> list){
        Map <String, Long> mapa = new HashMap<>();
        mapa = list.stream()
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return mapa;
    }
}

