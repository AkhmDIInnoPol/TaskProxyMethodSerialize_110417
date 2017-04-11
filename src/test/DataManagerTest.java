package test;

import library.models.Book;
import library.utils.DataManager;
import library.utils.SerializeInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Di on 11.04.2017.
 */
public class DataManagerTest
{



    @Test
    public void deserializeTest()
    {
        DataManager dataManager = new DataManager();


        SerializeInterface serInt = (SerializeInterface) Proxy.newProxyInstance(DataManager.class.getClassLoader(),
                new Class[]{SerializeInterface.class},
                new DataManagerProxy());


        Set<Book> trueBooks = serInt.deserializeBook();

        Set<Book> books = dataManager.deserializeBook();

        for (Book book:books
             ) {
            assertTrue(trueBooks.contains(book));
        }

        assertTrue(trueBooks.size() == books.size());

    }




}
