import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Matt on 2017-08-05.
 */
public class TestDisplayQR {

    public static void main(String[] args) throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        //poprawić ścieżki dostepu
        List<Facebook>listOfFbObjects = new ArrayList<>();
        listOfFbObjects.add(mapper.readValue(new File("/home/mateusz/IdeaProjects/QR/src/main/resources/f1.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(new File("/home/mateusz/IdeaProjects/QR/src/main/resources/f2.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(new File("/home/mateusz/IdeaProjects/QR/src/main/resources/f3.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(new File("/home/mateusz/IdeaProjects/QR/src/main/resources/f4.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(new File("/home/mateusz/IdeaProjects/QR/src/main/resources/f5.json"), Facebook.class));

        FacebookSericeImpl facebookSerice = new FacebookSericeImpl(listOfFbObjects);
        facebookSerice.findAll();
        facebookSerice.findById("3");
        facebookSerice.findPostIdsByKeyword("absolutely");
        facebookSerice.findMostCommonWords();

   /*
        try {
            value = mapper.readValue(new File("/home/mateusz/IdeaProjects/QR/src/main/resources/f1.json"), Facebook.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
      /*  System.out.println(value);

        String [] arrayTest=value.getPosts().get(1).getMessage().split(" ");
        String [] arrayTest2=value.getPosts().get(0).getMessage().split(" ");
        String [] result = (String[]) ArrayUtils.addAll(arrayTest, arrayTest2);
        String [] resultFinal = value.getPosts().get(2).getMessage().split(" ");
        String [] resultFinals = (String[]) ArrayUtils.addAll(resultFinal,result);

        List <String> listaString = Arrays.asList(resultFinals);
        System.out.println(findMostCommonWords(listaString));*/

}

    public static Map<String, Long> findMostCommonWords(List <String> list){
        Map <String, Long> mapa = new HashMap<>();
        mapa = list.stream()
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return mapa;
    }
}

