package BancoDeDados;

import java.sql.*;

public class RegistroDesenhos
{
    public static void incluir (RegistroDesenho registroDesenho) throws Exception
    {
        if (registroDesenho==null)
            throw new Exception ("Registro de Desenho nao fornecido");

        try
        {
            //OBS - POSSIVEL ERRO - NULL
            
            String sql;

            sql = "INSERT INTO RegistroDesenhos " +
                  "(nomeDesenho, idCliente, dataCriacao, dataModificacao) " +
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

    public static int getIdExistente (String nomeDesenho, String idCliente) throws Exception
    {
        int id;
        
        try
        {
            String sql;

            sql = "SELECT idDesenho " +
                  "FROM RegistroDesenhos " +
                  "WHERE nomeDesenho = ? AND idCliente = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, nomeDesenho);
            BDSQLServer.COMANDO.setString (2, idCliente);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            resultado.first();
            
            id = resultado.getInt ("idDesenho");
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar id");
        }
        
        return id;
    }
    
    public static void alterar (String dataModificacao, int idDesenho) throws Exception
    {
         try
        {
            String sql;

            sql = "UPDATE RegistroDesenhos " +
                  "SET dataModificacao = ? " +
                  "WHERE idDesenho = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString (1, dataModificacao);
            BDSQLServer.COMANDO.setInt    (2, idDesenho);

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
    
    public static int idAtual () throws Exception
    {
        int idAtual;
        
        try
        {
            String sql;

            sql = "SELECT idDesenho " +
                  "FROM RegistroDesenhos ";

            BDSQLServer.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            resultado.last();
            
            idAtual = resultado.getInt(1);
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar id");
        }
        
        return idAtual;
    }
    
    public static boolean verificaNome (String nomeDesenho, String idCliente) throws Exception
    {
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM RegistroDesenhos " +
                  "WHERE nomeDesenho = ? AND idCliente = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, nomeDesenho);
            BDSQLServer.COMANDO.setString (2, idCliente);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
            
            return resultado.first();  
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar desenho");
        }
    }
    
    //NÃO tem atributos para fazer toString, equals e hashCode
    
}
