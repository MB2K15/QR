import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.autoconfigure.social.FacebookProperties;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Matt on 2017-08-05.
 */
public class TestDisplayQR {

    public static void main(String[] args) throws WriterException, IOException, org.json.simple.parser.ParseException {

        /* BitMatrix byteMatrix = new QRCodeWriter().encode(
            "http://meczyki.pl/", BarcodeFormat.QR_CODE, 300, 400);
    MatrixToImageWriter.writeToStream(byteMatrix, "png",
            new FileOutputStream("C://tmp/qr_code_testing.png"));*/

/*
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "roman");
        jsonObject.put("age", new Integer(50));
        jsonObject.put("postcode", "30-040");

        JSONArray list = new JSONArray();
        list.add("message1");
        list.add("message2");
        list.add("message3");
        list.add("message4");

        jsonObject.put("messages", list);

        try (FileWriter file = new FileWriter("C://tmp/test.json")) {

            file.write(jsonObject.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(jsonObject);



        /////////////////////*/

        JSONParser parser = new JSONParser();

        ObjectMapper mapper = new ObjectMapper();

        /**
         * Read object from file
         */
        Facebook value = null;
        try {
            value = mapper.readValue(new File("C:\\\\Users\\\\Matt\\\\Desktop\\\\JSF\\\\QR\\\\src\\\\main\\\\resources\\\\f1.json"), Facebook.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(value);

        /*Object obj = parser.parse(new FileReader("C:\\Users\\Matt\\Desktop\\JSF\\QR\\src\\main\\resources\\f1.json"));

        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject);

        Facebook facebook1 = new Facebook();
        facebook1.setFirstname((String) jsonObject.get("firstname"));
        System.out.println(facebook1.getFirstname());

        long age = (Long) jsonObject.get("birthday");
        System.out.println(age);

        String relationship = (String) jsonObject.get("relationship");
        System.out.println(relationship);

        JSONArray friends = (JSONArray) jsonObject.get("friends");
        Iterator<String> iterator = friends.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        JSONArray slideContent = (JSONArray) jsonObject.get("city");
        Iterator i = slideContent.iterator();
        while (i.hasNext()) {
            JSONObject slide = (JSONObject) i.next();
            String title = (String)slide.get("countryName");
        }

        //jsonObject.getJSONObject("result").getJSONObject("map").getJSONArray("entry");
*/
        String [] array = {"dwa","jeden", "jeden","jeden", "dwa", "trzy", "dwa"};
        List<String> list = Arrays.asList(array);

        System.out.println(findMostCommonWords(list));

}

    public static Map<String, Long> findMostCommonWords(List <String> list){
        Map <String, Long> mapa = new HashMap<>();
        mapa = list.stream()
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return mapa;
    }
}

