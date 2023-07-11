package jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Taka26.");
        Statement st= con.createStatement();


        String sql1=  "CREATE TABLE workers(worker_id VARCHAR(50),worker_name VARCHAR(50), worker_salary INT)";
boolean result = st.execute(sql1);
        System.out.println(result);

        String sql2="ALTER TABLE workers ADD worker_adres VARCHAR(80)";
        st.execute(sql2);

        String sql3= "DROP TABLE workers";
        st.execute(sql3);

        con.close();
        st.cancel();
    }
}
