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
   
    public String toString ()
    {
        return (this.desenho.toString());
    }
    
    //add equals    
}
