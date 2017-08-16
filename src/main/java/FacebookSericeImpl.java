
import javax.ws.rs.NotFoundException;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by mateusz on 16.08.17.
 */
public class FacebookSericeImpl implements FacebookService {

    private List<Facebook> listOfFacebbokAcounts;

    public FacebookSericeImpl(List<Facebook>listOfFacebbokAcounts) {
        this.listOfFacebbokAcounts=listOfFacebbokAcounts;
    }

    @Override
    public Facebook findById(String id)throws NotFoundException {
       Facebook facebook = listOfFacebbokAcounts.stream()
               .filter(f->id.equals(f.getId()))
               .findFirst()
               .orElse(null);

        if(facebook==null)
            throw new NotFoundException();

        return facebook;
        /* Facebook facebook = new Facebook();
        for (Facebook element :listOfFacebbokAcounts) {
            if (id.equals(element.getId()))
                facebook = element;
        }
        return facebook;*/
    }

    @Override
    public Map<String, Long> findMostCommonWords() {
        List<Post>listTest = new ArrayList<>();
        List<String>list = new ArrayList<>();
        Map <String, Long> mapa = new HashMap<>();
        for(Facebook element:this.listOfFacebbokAcounts){
            listTest.addAll(element.getPosts());
        }
        for(Post postTest:listTest){
            list.add(postTest.getMessage());
        }
        mapa = list.stream()
                .map(s1->s1.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return mapa;//usuwanie znaków
    }

    @Override
    public Set<String> findPostIdsByKeyword(String word) {
        Set<String> setFB = new HashSet<String>();
        for(Facebook element:this.listOfFacebbokAcounts)
        {
            for(Post post:element.getPosts()){
                if(post.getMessage().contains(word)){
                    setFB.add(post.getId());
                }
                //flatmap nested streams
            }
        }
        return setFB;
    }

    @Override
    public Set<Facebook> findAll() {
        return (this.listOfFacebbokAcounts).stream()
                .sorted(Comparator.comparing(Facebook::getFirstname).thenComparing(Facebook::getLastname))
                .collect(Collectors.toSet());
        //komparator
    }
}
