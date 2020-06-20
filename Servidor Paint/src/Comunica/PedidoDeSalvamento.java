package Comunica;

public class PedidoDeSalvamento extends Comunicado
{
    private Desenho desenho;
    
    public PedidoDeSalvamento (Desenho desenho)
    {
        this.desenho = desenho;
    }
    
    public void setDesenho (Desenho desenho)
    {
        this.desenho = desenho;
    }
    
    public Desenho getDesenho ()
    {
        return this.desenho;
    }
    
    public String getNomeDesenho ()
    {
        return this.desenho.getNomeDesenho();
    }
    
    public String getIdCliente ()
    {
        return this.desenho.getIdCliente();
    }
    
    public String getDataCriacao ()
    {
        return this.desenho.getDataCriacao();
    }
    
    public String getDataModificacao ()
    {
        return this.desenho.getDataModificacao();
    }
   
    public String toString ()
    {
        return (this.desenho.toString());
    }
    
    //add equals    
}
