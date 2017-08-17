
import java.util.Map;
import java.util.Set;

/**
 * Created by Matt on 2017-08-15.
 */
public interface FacebookService {

    Facebook findById(String id) throws NotFoundException;
    Map<String, Long> findMostCommonWords();
    Set<String> findPostIdsByKeyword(String word);
    Set<Facebook> findAll();

}
