package BancoDeDados;

import java.sql.*;

public class RegistroDesenhos
{
    public static boolean cadastrado (int idDesenho) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM RegistroDesenhos " +
                  "WHERE idDesenho = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idDesenho);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar desenho");
        }

        return retorno;
    }

    public static void incluir (RegistroDesenho registroDesenho) throws Exception
    {
        if (registroDesenho==null)
            throw new Exception ("Registro de Desenho nao fornecido");

        try
        {
            //OBS - POSSIVEL ERRO - NULL
            
            String sql;

            sql = "INSERT INTO RegistroDesenhos " +
                  "(nomeDesenho, idCliente, dataCricao, dataModificacao) " +
                  "VALUES " +
                  "(?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, registroDesenho.getNomeDesenho());
            BDSQLServer.COMANDO.setString (2, registroDesenho.getIdCliente());
            BDSQLServer.COMANDO.setString (3, registroDesenho.getDataCriacao());
            BDSQLServer.COMANDO.setString (4, registroDesenho.getDataModificacao());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir desenho");
        }
    }

    public static void excluir (int idDesenho) throws Exception
    {
        if (!cadastrado (idDesenho))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM RegistroDesenhos " +
                  "WHERE idDesenho=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idDesenho);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();        
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir desenho");
        }
    }

    public static void alterar (RegistroDesenho registroDesenho) throws Exception
    {
        if (registroDesenho==null)
            throw new Exception ("Registro de Desenho não fornecido");

        if (!cadastrado (registroDesenho.getIdDesenho()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE RegistroDesenhos " +
                  "SET dataModificacao=? " +
                  "WHERE idDesenho = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            //obs - possivel erro
            
            BDSQLServer.COMANDO.setString (1, registroDesenho.getDataModificacao());
            BDSQLServer.COMANDO.setInt    (2, registroDesenho.getIdDesenho());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados do desenho");
        }
    }

    public static RegistroDesenho getRegistroDesenho (int idDesenho) throws Exception
    {
        RegistroDesenho registroDesenho = null;

        try
        {
            //POSSIVEL ERRO - ID
            
            String sql;

            sql = "SELECT * " +
                  "FROM RegistroDesenhos " +
                  "WHERE idDesenho = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idDesenho);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            registroDesenho = new RegistroDesenho (resultado.getString ("nomeDesenho"),
                                                   resultado.getString ("idCliente"),
                                                   resultado.getString ("dataCriacao"),
                                                   resultado.getString ("dataModificacao"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar desenho");
        }

        return registroDesenho;
    }

    public static MeuResultSet getRegistroDesenhos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM RegistroDesenhos";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar desenhos");
        }

        return resultado;
    }
}
