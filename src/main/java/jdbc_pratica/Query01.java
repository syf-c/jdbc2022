package jdbc_pratica;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.Adim:Driver'a kaydol
        //2.Adim: Database'e baglan
        //3.Adim:Statement olustur
        //4.Adim:Query calistir

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Taka26.");
        Statement st= con.createStatement();
        ResultSet veri=st.executeQuery("select*from ogrenciler");
        while(veri.next()){
            System.out.println(veri.getInt(1)+ veri.getString(2)+ veri.getString(3)+veri.getString(4));


        }
        con.close();
        st.close();
        veri.close();

    }
}
