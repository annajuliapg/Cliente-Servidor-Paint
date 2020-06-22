package BancoDeDados;

import java.sql.SQLException;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            System.out.println("\nConectando ao banco...");
            
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://localhost:1433;databasename=master",
            "sa", "Syst3mSyst3m");
            
            System.out.println("Banco de Dados Conectado!");
        }
        catch (ClassNotFoundException erro)
        {
            System.err.println ("Problemas de conexao com o BD CLASSE");
            System.exit(0); // aborta o programa
        }
        catch (SQLException erro)
        {
            System.err.println ("Problemas de conexao com o BD SQL");
            System.out.println(erro.getErrorCode());
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
    }
}