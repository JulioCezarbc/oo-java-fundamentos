package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConn();
            st = conn.prepareStatement(
            "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId )"
                    + "VALUES "
                    + "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Carl Blue");
            st.setString(2,"carlBlue@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("25/05/1985").getTime()));
            st.setDouble(4,3000.0);
            st.setInt(5,4);

            int rowAf = st.executeUpdate();

            if (rowAf > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Id: " + id);
                }

            }
            else {
                System.out.println("Nenhuma linha alterada! ");
            }


        }
        catch (SQLException | ParseException e){
            e.printStackTrace();
        } finally {
            DB.closeSt(st);
            DB.closeCon();
        }
    }
}
