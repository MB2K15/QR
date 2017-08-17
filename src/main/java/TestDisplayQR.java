import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Matt on 2017-08-05.
 */
public class TestDisplayQR {

    public static void main(String[] args) throws Exception {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        ObjectMapper mapper = new ObjectMapper();

        List<Facebook>listOfFbObjects = new ArrayList<>();
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f1.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f2.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f3.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f4.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f5.json"), Facebook.class));

        FacebookSericeImpl facebookSerice = new FacebookSericeImpl(listOfFbObjects);
        //facebookSerice.findAll();
        //System.out.println(facebookSerice.findById("77"));
        List<Facebook>listatest = new ArrayList<>();
        Set<Facebook>set = facebookSerice.findAll();

        for(Facebook fb:set){
            System.out.println(fb.getFirstname());
            System.out.println(fb.getLastname());
        }

    }
}

