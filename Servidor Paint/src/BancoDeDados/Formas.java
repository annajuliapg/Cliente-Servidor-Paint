package BancoDeDados;

import java.sql.*;

public class Formas 
{
    public static boolean cadastrado (int idDesenho) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Formas " +
                  "WHERE idDesenho = ?";

            BDOracle.COMANDO.prepareStatement (sql);

            BDOracle.COMANDO.setInt (1, idDesenho);

            MeuResultSet resultado = (MeuResultSet)BDOracle.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar forma");
        }

        return retorno;
    }

    public static void incluir (Forma forma) throws Exception
    {
        if (forma==null)
            throw new Exception ("Forma nao fornecida");

        try
        {
                       
            String sql;

            sql = "INSERT INTO Formas " +
                  "(idCliente, figura) " +
                  "VALUES " +
                  "(?,?)";

            BDOracle.COMANDO.prepareStatement (sql);

            BDOracle.COMANDO.setInt (1, forma.getIdDesenho());
            BDOracle.COMANDO.setString (2, forma.getFigura());

            BDOracle.COMANDO.executeUpdate ();
            BDOracle.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            BDOracle.COMANDO.rollback();
            throw new Exception ("Erro ao inserir forma");
        }
    }

    public static void excluir (int idDesenho) throws Exception
    {
        if (!cadastrado (idDesenho))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM Formas " +
                  "WHERE idDesenho=?";

            BDOracle.COMANDO.prepareStatement (sql);

            BDOracle.COMANDO.setInt (1, idDesenho);

            BDOracle.COMANDO.executeUpdate ();
            BDOracle.COMANDO.commit        ();        
        }
        catch (SQLException erro)
        {
            BDOracle.COMANDO.rollback();
            throw new Exception ("Erro ao excluir forma");
        }
    }

    public static Forma getForma (int idDesenho) throws Exception
    {
        Forma forma = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Formas " +
                  "WHERE idDesenho = ?";

            BDOracle.COMANDO.prepareStatement (sql);

            BDOracle.COMANDO.setInt (1, idDesenho);

            MeuResultSet resultado = (MeuResultSet)BDOracle.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            forma = new Forma (resultado.getInt ("idDesenho"),
                               resultado.getString("figura"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar forma");
        }

        return forma;
    }

    public static MeuResultSet getFormas () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Formas";

            BDOracle.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDOracle.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar formas");
        }
        
        return resultado;
    }
}
