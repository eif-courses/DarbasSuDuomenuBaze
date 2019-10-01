package db;

import exceptions.MultiplyByZeroRuntimeException;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import javax.swing.*;

public class Main {

  public static void multiply(int skaicius, int daugiklis) throws MultiplyByZeroRuntimeException {
    if(daugiklis == 0){
      throw new MultiplyByZeroRuntimeException("Daugyba is nulio negalima!");
    }else{
      System.out.println("Rezultatas: "+ (skaicius * daugiklis));
    }
  }

  public static void main(String[] args) {
    DuomenuBazesOperacijos db = new DuomenuBazesOperacijos();
    //db.iterpti("Du litai", 2, "litas")

    multiply(10, 5);
    multiply(10, 0);

  }

}
