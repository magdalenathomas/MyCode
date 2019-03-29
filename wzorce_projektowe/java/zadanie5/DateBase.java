package zadanie5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DateBase implements Repository{

	private Connection conn;
	private String title;

	public DateBase(String host, String user, String pass) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + host
					+ ":3306/diary?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() throws IOException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public void getAll() throws Exception {
		List<BooksItem> all = new ArrayList<>();
		try (Statement stm = conn.createStatement()) {
			ResultSet res = stm.executeQuery("SELECT * FROM booksitem");
			while (res.next()) {
				BooksItem item = new BooksItem(res.getString("title"), res.getString("author"),
						res.getDate("releaseDate"), res.getInt("quantity"));
				all.add(item);
			}
			res.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}

		BooksItem[] result = new BooksItem[all.size()];
		for (int ix = 0; ix < all.size(); ix++) {
			System.out.println(result[ix] = all.get(ix));
		}
	}
	
	public void find(String title) throws Exception {
		this.title = title;
		List<BooksItem> book = new ArrayList<>();
		try (Statement stm = conn.createStatement()) {
			ResultSet result = stm.executeQuery("SELECT author, releaseDate, quantity FROM booksitem where title = title");
			while (result.next()) {
				BooksItem item = new BooksItem(result.getString("title"), result.getString("author"),
						result.getDate("releaseDate"), result.getInt("quantity"));
				book.add(item);
			}
			result.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}
		
		BooksItem[] result = new BooksItem[book.size()];
		for (int ix = 0; ix < book.size(); ix++) {
			System.out.println(result[ix] = book.get(ix));
		}
	}

}
