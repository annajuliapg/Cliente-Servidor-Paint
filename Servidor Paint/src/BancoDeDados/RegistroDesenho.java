package BancoDeDados;

// DBO - Colunas da tabela

public class RegistroDesenho 
{
    private String nomeDesenho;
    private String idCliente;
    private String dataCriacao;
    private String dataModificacao;
    private int    idDesenho;
    
    public void setNomeDesenho(String nomeDesenho) throws Exception
    {
        if (nomeDesenho==null || nomeDesenho.equals(""))
            throw new Exception ("Nome não fornecido");
        
        this.nomeDesenho = nomeDesenho;
    }
    
    public void setIdCliente(String idCliente) throws Exception
    {
        if (idCliente==null || idCliente.equals(""))
            throw new Exception ("Id não fornecido");
        
        this.idCliente = idCliente;
    }
    
    public void setDataCriacao(String dataCriacao) throws Exception
    {
        if (dataCriacao==null || dataCriacao.equals(""))
            throw new Exception ("Data de criação não fornecida");
        
        this.dataCriacao = dataCriacao;
    }
    
    public void setDataModificacao(String dataModificacao) throws Exception
    {
        if (dataModificacao==null || dataModificacao.equals(""))
            throw new Exception ("Data de modificação não fornecida");
        
        this.dataModificacao = dataModificacao;
    }
    
    public void setIdDesenho(int idDesenho) throws Exception
    {
        if (idDesenho <= 0)
            throw new Exception ("Id inválido");
        
        this.idDesenho = idDesenho;
    }
    
    public String getNomeDesenho ()
    {
        return this.nomeDesenho;
    }
    
    public String getIdCliente ()
    {
        return this.idCliente;
    }
    
    public String getDataCriacao ()
    {
        return this.dataCriacao;
    }
    
    public String getDataModificacao ()
    {
        return this.dataModificacao;
    }
    
    public int getIdDesenho ()
    {
        return this.idDesenho;
    } 
    
    public RegistroDesenho (String nomeDesenho, String idCliente, String dataCriacao, String dataModificacao) throws Exception
    {
        this.setNomeDesenho (nomeDesenho);
        this.setIdCliente (idCliente);
        this.setDataCriacao (dataCriacao);
        this.setDataModificacao (dataModificacao);
    }
    
    @Override
    public String toString ()
    {
        String ret="";

        ret+="Nome Desenho: "+this.nomeDesenho + "\n";
        ret+="Id Cliente: "+this.idCliente + "\n";
        ret+="Data Criação: "+this.dataCriacao + "\n";
        ret+="Data Modificação: "+this.dataModificacao;
        ret+="Id Desenho: "+this.idDesenho;
        
        return ret;
    }
    
}
