package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;


public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConn();

            conn.setAutoCommit(false);
            st = conn.createStatement();

            int linha1 = st.executeUpdate("UPDATE seller SET BaseSalary =2090 WHERE DepartmentId = 1");

//            int x =1;
//            if (x <3){
//                throw new SQLException("Fake erro");
//            }

            int linha2 = st.executeUpdate("UPDATE seller SET BaseSalary =3090 WHERE DepartmentId = 2");

            conn.commit();
            System.out.println("Linha1 " + linha1);
            System.out.println("Linha2 " + linha2);

        }
        catch (SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Erro: " + e.getMessage() );
            }catch (SQLException e1){
                throw new DbException("erro: " + e1.getMessage());
            }
        }
        finally {
            DB.closeSt(st);
            DB.closeCon();
        }
    }
}
