package zadanie5;

import java.io.Closeable;

public interface Repository extends Closeable {

    public void getAll() throws Exception;
    public void find(String title) throws Exception;

}
