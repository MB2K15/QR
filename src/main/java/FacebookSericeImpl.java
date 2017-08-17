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
    public Facebook findById(String id) throws NotFoundException{
        Facebook facebook = listOfFacebbokAcounts.stream()
                .filter(f->id.equals(f.getId()))
                .findFirst()
                .orElse(null);
        if(facebook==null)
            throw new NotFoundException();
        return facebook;
    }

    @Override
    public Map<String, Long> findMostCommonWords() {
        Map <String, Long> mapa = new HashMap<>();
        mapa = listOfFacebbokAcounts
                .stream()
                .map(Facebook::getPosts)
                .flatMap(List::stream)
                .map(Post::getMessage)
                .map(s -> s.replaceAll("[!@?.:,()]", ""))
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return mapa;
    }

    @Override
    public Set<String> findPostIdsByKeyword(String word) {
        return listOfFacebbokAcounts
                .stream()
                .map(Facebook::getPosts)
                .flatMap(List::stream)
                .filter(post -> post.getMessage().contains(word))
                .map(Post::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Facebook> findAll() {
        return (this.listOfFacebbokAcounts).stream()
                .sorted(Comparator.comparing(Facebook::getFirstname).thenComparing(Facebook::getLastname))
                .collect(Collectors.toSet());
    }
}
