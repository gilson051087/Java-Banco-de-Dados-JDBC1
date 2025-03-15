package application;
import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Program {
    public static void main(String[] args) throws SQLException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentID) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);



            //trocando a interrogração pela string


            //Montando o comando de sql
            st.setString(1, "Gilson Elias");
            st.setString(2, "gilson@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("05/10/1987").getTime()));
            st.setDouble(4, 3000);
            st.setInt(5, 4);

            // Para executar a função
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rown affected");
            }



        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();

        }
    }
}
