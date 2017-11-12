import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Matt on 2017-08-05.
 */
public class FacebookMain {

    public static void main(String[] args) throws Exception {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        ObjectMapper mapper = new ObjectMapper();

        List<Facebook>listOfFbObjects = new ArrayList<>();
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f1.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f2.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f3.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f4.json"), Facebook.class));
        listOfFbObjects.add(mapper.readValue(classloader.getResource("f5.json"), Facebook.class));

        FacebookSericeImpl facebookService = new FacebookSericeImpl(listOfFbObjects);
        System.out.println(facebookService.findAll());
        
        System.out.println(facebookService.findMostCommonWords());
        


    }
}

