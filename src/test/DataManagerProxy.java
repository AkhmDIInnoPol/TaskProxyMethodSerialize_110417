package test;

import library.models.Book;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Di on 11.04.2017.
 */
public class DataManagerProxy implements InvocationHandler
{


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if (method.getName() == "deserializeBook")
        {
            Set<Book> books = new HashSet<>();
            try(FileInputStream fis = new FileInputStream("books.txt");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

                Book book = null;
                while((book = (Book) ois.readObject()) != null) {
                    books.add(book);
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                return books;
            }



        }

        return null;
    }
}
