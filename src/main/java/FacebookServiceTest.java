import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mateusz on 16.08.17.
 */
public class FacebookServiceTest {

    ObjectMapper mapper = new ObjectMapper();
    private List<Facebook>listOfFbObjectsTest = new ArrayList<>();

    FacebookSericeImpl facebookService;
    private static final String ID = "2";
    private static final String ID_EXCEPTION = "77";
    private static final String WORD = "absolutely";

    @Before
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        listOfFbObjectsTest.add(mapper.readValue(classloader.getResource("f1.json"), Facebook.class));
        listOfFbObjectsTest.add(mapper.readValue(classloader.getResource("f2.json"), Facebook.class));
        listOfFbObjectsTest.add(mapper.readValue(classloader.getResource("f3.json"), Facebook.class));
        listOfFbObjectsTest.add(mapper.readValue(classloader.getResource("f4.json"), Facebook.class));
        listOfFbObjectsTest.add(mapper.readValue(classloader.getResource("f5.json"), Facebook.class));
        facebookService=new FacebookSericeImpl(listOfFbObjectsTest);
    }

    @org.junit.Test
    public void testFindById() throws Exception {

        Facebook facebookActual=facebookService.findById(ID);
        Assert.assertEquals(listOfFbObjectsTest.get(1), facebookActual);
    }

    @org.junit.Test(expected = NotFoundException.class)
    public void testFindByIdException() throws Exception {
        facebookService.findById(ID_EXCEPTION);
    }

    @org.junit.Test
    public void testFindMostCommonWords() throws Exception {
        Map<String, Long> map = facebookService.findMostCommonWords();
        Assert.assertNotNull(map);
        Long longTest = map.get(WORD);
        Assert.assertEquals(new Long(2),longTest);
    }

    @org.junit.Test
    public void testFindPostIdsByKeyword() throws Exception {
        Set<String> setFacebbokTestActual = facebookService.findPostIdsByKeyword(WORD);
        Assert.assertEquals(2, setFacebbokTestActual.size());
    }

    @org.junit.Test
    public void testFindAll() throws Exception {
        Set<Facebook> facebookTestSetactual = facebookService.findAll();
        Assert.assertEquals(5,facebookTestSetactual.size());
    }
}