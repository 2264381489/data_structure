import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import oracle.net.aso.c;
import oracle.net.aso.i;

public class homework_copy {
	// ???????????????
	private static String urlString;// ????url
	private static String nameString;// ??????????
	private static String passwdString;// ?????????
	private static Connection connection;// connection????
	static boolean flag = true;// flag
	private static int formnumber = 2;
	// ??????????
	static {
		// ?????????Driver??
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// ????????????????
		try {
			InputStream inputStream = homework.class.getClassLoader().getResourceAsStream("db1.properties");// ??homework????????????????????????
			Properties properties = new Properties();
			properties.load(inputStream);
			nameString = (String) properties.get("oracle.user");
			passwdString = (String) properties.get("oracle.password");
			urlString = (String) properties.get("oracle.url");
			System.out.println(nameString + " " + passwdString + " " + urlString + " ");
			inputStream.close();// ????????

//			Connection connection=DriverManager.getConnection(arg0)

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * ??????? @return???????????.
	 */
	public static Connection geConnection() {
		try {
			connection = DriverManager.getConnection(urlString, nameString, passwdString);
			System.out.println("??????");
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * ?????
	 */
	public static void Queryexcute() {
		String sqlString = "select*from commodity";
		try {
			Statement Statement = connection.createStatement();
			ResultSet resultSet = Statement.executeQuery(sqlString);
			while (resultSet.next()) {
				int d = resultSet.getInt(1);
				String nameString = resultSet.getString(2);
				System.out.println(d + "?????" + nameString);
			}
			System.out.println("????????");
			Statement.close();// ???
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * ????
	 * 
	 * @param args
	 */
	public static void buy() {

		// ???????????
		if (flag) {
			System.out.println("??????????,????....");
			try {
				Statement statement = connection.createStatement();
				statement.execute("create table form" + formnumber + "(id number(4),name varchar2(10),sid number(4))");
				statement.close();// ???
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// ??????????????
				System.out.println("??????????????,???????????");
				e.printStackTrace();
			}
			flag = false;
		} else {
			System.out.println("???????????");
		}
		// ????????????????
		int z = 0;
		Queryexcute();
		System.out.println("???????????????,????0??????");
		while (z == 0) {
			Scanner scanner = new Scanner(System.in);// ????
			int i = scanner.nextInt();
			switch (i) {
			case 0:
				z = 1;
				break;
			case 1:
				updateExucute(1);
				break;
			case 2:
				updateExucute(2);
				break;
			case 3:
				updateExucute(3);
				break;

			default:
				updateExucute(i);
				break;
			}

//		scanner.close();//???
		}

		System.out.println("лл???");
	}

	/**
	 * ????????????
	 * 
	 * @param args
	 */
	private static void updateExucute(int i) {
		try {
			PreparedStatement statement = connection.prepareStatement("select*from  commodity where id=?");// ????????????
			statement.setInt(1, i);// ???????
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String nameString = resultSet.getString(2);
				System.out.println(id + " " + nameString);
				PreparedStatement statement2 = connection
						.prepareStatement("insert into form" + formnumber + " values(?,?,?)");// ?????????????
				statement2.setInt(1, id);
				statement2.setString(2, nameString);
				statement2.setInt(3, formnumber);
				// ???
				System.out.print("????" + statement2.executeUpdate());
				statement2.close();
			}
			// ???
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("??????");
	}

	/**
	 * ??????
	 */
	public static void showShoppingcar() {
		if (!flag) {

			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select id,name,count(id) from form" + formnumber + " group by id,name");
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String nameString = resultSet.getString(2);
					int num = resultSet.getInt(3);
					System.out.println(id + "?????" + nameString + "????" + num);
				}

				statement.close();// ???
				resultSet.close();// ???
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("?????????????!");
		}
	}

	/**
	 * ??????????
	 * 
	 */
	private static boolean showShoppingcar(int i) {
		if (!flag) {
			System.out.println("");
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select rownum,id,name from form" + formnumber);
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String nameString = resultSet.getString(3);
					System.out.println(id + "?????" + nameString);
				}

				statement.close();// ???
				resultSet.close();// ???
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {
			System.out.println("?????????????!");
			return false;
		}
	}

	/**
	 * ???????
	 */
	public static void delete() {
		System.out.println("????????????????");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("delete  from  form" + formnumber + " where rownum=?");
			statement.setInt(1, i);// ???????
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ????????????

	}

	/**
	 * ??????
	 * 
	 * @param args
	 */
	public static void check() {
		System.out.println("????????");
		if (!flag) {

			try {
				PreparedStatement statement = connection.prepareStatement("insert into formlist values(?)");
				statement.setInt(1, formnumber);
				statement.execute();
				formnumber++;
				flag = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("?????????????????");
		}
	}

	/**
	 * ??????
	 * 
	 * @param args
	 */
	private static void formList() {
		try {
			// ?????????????
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select num from formlist");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println(id + "?????");
			}

			statement.close();// ???
			resultSet.close();// ???
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// ?????б?

	/**
	 * ??????????
	 * 
	 * @param args
	 */
	public static void detailForm() {
		formList();
		System.out.println("???????????????????????????.");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		if (i <= formnumber && i > 0) {

			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select rownum,id,name from form" + i);
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String nameString = resultSet.getString(3);
					System.out.println(id + "?????" + nameString);
				} // ???????????б?????

				statement.close();// ???
				resultSet.close();// ???
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("???????????????????!");
		}
	}

	/**
	 * ??????
	 * 
	 * @param args
	 */
	public static void deleteform(int i) {
		if (i > formnumber) {
			System.out.println("????????");
		} else {
			try {
				// ?????????????
				Statement statement = connection.createStatement();
				statement.executeUpdate("drop table form" + i);
				statement.executeUpdate("delete from formList where num =" + i);
				statement.close();// ???

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
//	//????
//	public static void main(String[] args) {
//		homework_copy.geConnection();
////		homework_copy.buy();
////		homework_copy.showShoppingcar();
////		homework_copy.delete();
////		homework_copy.check();
//		homework_copy.formList();
//		homework_copy.detailForm();
//		homework_copy.deleteform(2);
//	}
//}
//	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		homework_copy.geConnection();
		int i = 0;
		while (i == 0) {
			System.out.println("1.??????,2.???????,3.??????,0???");
			Scanner scanner = new Scanner(System.in);
			int j = scanner.nextInt();
			switch (j) {

			case 1:
				homework_copy.Queryexcute();// ??????
				int flag = 0;
				while (flag == 0) {
					System.out.println("1.????,2.????,3.???????");
					Scanner scanner1 = new Scanner(System.in);
					int j1 = scanner1.nextInt();
					switch (j1) {
					case 1:
						homework_copy.buy();
						break;
					case 2:
						homework_copy.showShoppingcar();
						break;
					default:
						flag = 1;
						break;
					}
				}
				break;
			case 2:
				int flag1 = 0;
				while (flag1 == 0) {
					if (!homework_copy.showShoppingcar(1))
						break;
					System.out.println("1.??????,2.???????,3.???????");
					Scanner scanner1 = new Scanner(System.in);
					int j1 = scanner1.nextInt();
					switch (j1) {
					case 1:
						homework_copy.delete();
						break;
					case 2:
						homework_copy.check();
						break;
					default:
						flag1 = 1;
						break;
					}
				}
				break;
			case 3:
				int flag2 = 0;
				while (flag2 == 0) {
					System.out.println("1.???????,2.??????????,3.???????");
					Scanner scanner1 = new Scanner(System.in);
					int j1 = scanner1.nextInt();
					switch (j1) {
					case 1:
						System.out.println("???????????????");
						Scanner scanner2 = new Scanner(System.in);
						int j2 = scanner1.nextInt();
						homework_copy.deleteform(j2);
						break;
					case 2:
						homework_copy.formList();
						homework_copy.detailForm();
						break;
					default:
						flag2 = 1;
						break;
					}
				}
				break;
			default:
				i = 1;
				break;
			}

		}
	}
}
