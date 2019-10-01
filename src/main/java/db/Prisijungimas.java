package db;

import exceptions.NameEqualityException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Prisijungimas implements AutoCloseable{

  private Connection connection;

  public Connection prijungti(String user, String password) throws NameEqualityException {
    String url = "jdbc:mysql://localhost:3306/saugykla";

    if(user.equals(password)){
      throw new NameEqualityException("Negalimas ivedimas: negalima ivesti slaptazodio ir username kuris sutaptu");
    }else{
      try {
        connection = DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }





    return connection;
  }

  @Override
  public void close() throws Exception {
    connection.close();
  }
}
