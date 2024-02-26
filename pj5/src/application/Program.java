package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;


public class Program {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement st = null;

        try {
            conn = DB.getConn();
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE " +
                            "Id = ?"
            );
            st.setInt(1,4);

            int row = st.executeUpdate();
            System.out.println("LINHAS: " + row);
        }
        catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeSt(st);
            DB.closeCon();
        }
    }
}
