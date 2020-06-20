package Comunica;

public class PedidoDeAbertura extends Comunicado
{    
    private double idCliente; //pode ser o ip
    private String nomeDesenho;
    
    public PedidoDeAbertura (double idCliente, String nomeDesenho)
    {
        this.idCliente = idCliente;
        this.nomeDesenho = nomeDesenho;
    }
    
    public void setNomeDesenho (String nomeDesenho)
    {
        this.nomeDesenho = nomeDesenho;
    }
    
    public void setIdCliente (double idCliente)
    {
        this.idCliente = idCliente;
    }
    
    public String getNomeDesenho ()
    {
        return this.nomeDesenho;
    }
    
    public double getIdCliente ()
    {
        return this.idCliente;
    }
   
    public String toString ()
    {
        return (""+this.idCliente+this.nomeDesenho);
    }
    
    //add equals

}
