package db;

import exceptions.NameEqualityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class DuomenuBazesOperacijos {
  private Connection connection;
  private Prisijungimas prisijungimas;

  public void iterpti(String pavadinimas, int kiekis, String valiuta){

    prisijungimas = new Prisijungimas();

    try {
      connection = prisijungimas.prijungti("root", "root");
    } catch (NameEqualityException e) {
      e.printStackTrace();
    }

    String sql = "insert into saugykla.pinigai values(?, ?, ?, ?)";

    try {
      PreparedStatement pre = connection.prepareStatement(sql);
      pre.setInt(1, new Random().nextInt(7000));
      pre.setString(2, pavadinimas);
      pre.setInt(3, kiekis);
      pre.setString(4, valiuta);
      pre.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

}
