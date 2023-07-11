package jdbc;

import java.sql.Connection;
import java.util.Collection;

public class main {
    public static void main(String[] args) {

        // DBWork objesini oluştue

        DBWork db =new DBWork();
        // connectionu cağır
        Connection con= db.connect_to_db("techproed","postgres","Taka26.");

        // yeni table metodunu cağır
        db.createTable(con,"employes table");

    }
}
