package zadanie5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import pl.codeme.diary.engine.Diary;
import pl.codeme.diary.engine.DiaryException;

public class Engine {

    private static Properties config;
    private final Repository repo;

    static {
        config = System.getProperties();
        try(InputStream config = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties")) {
            Engine.config.load(config);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private static Engine instance;

    public static Engine getInstance() {
        if(instance == null) {
            instance = new Engine();
        }
        return instance;
    }

    public static Properties getConfig() {
        return config;
    }
    
    private Engine() {

        try {
            Repository repo = null;
            String repoType = config.getProperty("zadanie5.engine.repository");
            if (repoType.equals("db")) {
            	repo = new DateBase("localhost", "root", "magda");
            } else {
            	System.out.println("błąd");
            }
       
      books = new BooksItem(repo, config.getProperty("zadanie5.engine"));
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
}
