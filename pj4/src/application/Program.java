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
            st = conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? " +
                    " WHERE DepartmentId = ?");
            st.setDouble(1,200);
            st.setInt(2,2);

            int row = st.executeUpdate();
            System.out.println("LINHAS: " + row);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeSt(st);
            DB.closeCon();
        }
    }
}
