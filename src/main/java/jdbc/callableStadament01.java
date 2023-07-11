package jdbc;

import java.sql.*;

public class callableStadament01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Taka26.");
        Statement st = con.createStatement();

        String sql1 ="CREATE or replace  FUNCTION toplamaf( x numeric , y numeric)\n" +
                "returns numeric\n" +
                "language plpgsql\n" +
                "as\n" +
                "$$\n" +
                " begin\n" +
                "\n" +
                " return x+y;\n" +
                "\n" +
                "\n" +
                " end\n" +
                "$$";

        // 2.adım fonksiyonu calıştır

        st.execute(sql1);

        // 3. adım fonksiyonu cağır

              CallableStatement cst1= con.prepareCall("{?=call toplamaf(?,?)}");

            // 4. adım
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,15);
        cst1.setInt(3,25);

          // 5. adım calıştırmak için execute() methodunukullan

        cst1.execute();

        // 6.adım : sonucu cağırmak için return data tipine göre " get" metotlarından uygun olan ı kullan
        System.out.println(cst1.getBigDecimal(1));

        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.

        String sql2 ="CREATE or replace  FUNCTION konihacmi( r numeric , h numeric)\n" +
                "returns numeric\n" +
                "language plpgsql\n" +
                "as\n" +
                "$$\n" +
                " begin\n" +
                "\n" +
                " return 3.14*r*r*h/3;\n" +
                "\n" +
                "\n" +
                " end\n" +
                "$$";

        // 2.adım fonksiyonu calıştır

        st.execute(sql2);

        // 3. adım fonksiyonu cağır

        CallableStatement cst2= con.prepareCall("{?=call konihacmi(?,?)}");

        // 4. adım
        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,3);
        cst2.setInt(3,5);

        // 5. adım calıştırmak için execute() methodunukullan

        cst2.execute();

        // 6.adım : sonucu cağırmak için return data tipine göre " get" metotlarından uygun olan ı kullan
        System.out.println(cst2.getBigDecimal(1));
    }
}
