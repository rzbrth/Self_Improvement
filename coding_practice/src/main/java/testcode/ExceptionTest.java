package testcode;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

public class ExceptionTest {


	public static void show() throws SQLException {
		throw new SQLException();
	}

	public static void dis() throws SQLException {
		show();
	}
	
	public static void that() throws WrongFileNameException {
	}
	public static void showss() throws IOException {
	}
	
	public static void main(String[] args) throws IOException {
		List<String> stringList = Arrays.asList("a", "b", "c");
		stringList.add("");
		that();
		 showss();
		try {
			dis();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
