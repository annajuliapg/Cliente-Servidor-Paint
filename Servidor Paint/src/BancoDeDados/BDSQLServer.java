package BancoDeDados;

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
            "/*usuario*/", "/*senha*/"); //inserir usuário e senha do SQL Server
            
            System.out.println("Banco de Dados Conectado!");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
    }
}
