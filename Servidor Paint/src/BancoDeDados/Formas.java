package BancoDeDados;

import Comunica.Desenho;
import java.sql.*;

public class Formas 
{
    public static void incluir (Forma forma) throws Exception
    {
        if (forma==null)
            throw new Exception ("Forma nao fornecida");

        try
        {
                       
            String sql;

            sql = "INSERT INTO Formas " +
                  "(idDesenho, figura) " +
                  "VALUES " +
                  "(?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, forma.getIdDesenho());
            BDSQLServer.COMANDO.setString (2, forma.getFigura());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir forma");
        }
    }

    public static void excluir (int idDesenho) throws Exception
    {
        try
        {
            String sql;

            sql = "DELETE FROM Formas " +
                  "WHERE idDesenho=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idDesenho);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();        
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir forma");
        }
    }

    public static void setFormasDesenho (int idDesenho, Desenho d) throws Exception
    {
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Formas " +
                  "WHERE idDesenho = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idDesenho);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");
            
            resultado.first();
            
            while(!resultado.isAfterLast())
            {
                d.addFigura (resultado.getString(2));
                resultado.next();
            }                            
            
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar forma");
        }
    }
    
    //NÃO tem atributos para fazer toString, equals e hashCode
}
