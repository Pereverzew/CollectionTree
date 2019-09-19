import com.pereverzew.collectiontree.CollectionTree;
import com.pereverzew.collectiontree.CollectionTreeImpl;
import com.pereverzew.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollectionTreeTest {
    private CollectionTree<User> tree= new CollectionTreeImpl<>();

    @Before
    public void init(){
        tree.add(new User("Fedor"));
        tree.add(new User("Inna"));
        tree.add(new User("Pavel"));
        tree.add(new User("Alex"));
        tree.add(new User("Oleg"));
        tree.add(new User("Vika"));
        tree.add(new User("Igor"));
        tree.add(new User("Oleg"));
    }

    @Test
    public void test_add() {
        User user= new User("Kostya");
        tree.add(user);
        Assert.assertEquals(user,tree.get(user).get());
    }

    @Test
    public void test_get() {
        User user= new User("Oleg");
        Assert.assertTrue(tree.get(user).isPresent());
    }

    @Test
    public void test_Delete() {
        User user= new User("Fedor");
        tree.delete(user);
        Assert.assertFalse(tree.get(user).isPresent());
    }
}

