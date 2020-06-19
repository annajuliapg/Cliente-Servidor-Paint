import java.net.*;
import java.util.*;

//DBO - uma linha da tabela

public class Desenho extends Comunicado
{    
    //"colunas da tabela"
    private String idCliente;
    private String nomeDesenho;
    private String dataCriacao;
    private String dataModificacao;
    private ArrayList<String> figuras;
    
    public Desenho (String nomeDesenho, String dataCriacao, String dataModificacao) throws UnknownHostException
    {
        this.idCliente = InetAddress.getLocalHost().getHostAddress();
        
        this.nomeDesenho = nomeDesenho;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.figuras = new ArrayList<String>();
    }
    
    public void setIdCliente(String idCliente)
    {
        this.idCliente = idCliente;
    }
    
    public String getIdCliente ()
    {
        return this.idCliente;
    }
    
    public void addFigura (String fig)
    {
        figuras.add(fig);
    }
    
    public String getFigura (int i)
    {
        return figuras.get(i);
    }
    
    public int getQtdFiguras ()
    {
        return figuras.size();
    }
    
    public String getNomeDesenho ()
    {
        return this.nomeDesenho;
    }
    
    public String getDataCriacao ()
    {
        return this.dataCriacao;
    }
    
    public String getDataModificacao ()
    {
        return this.dataModificacao;
    }
   
    public String toString ()
    {
        return ("Ip do Cliente: "+this.idCliente+"\n"+
                "Nome do Desenho: "+this.nomeDesenho+"\n"+
                "Data da Criação: "+this.dataCriacao+"\n"+
                "Data da Modificação: "+this.dataModificacao+"\n"+
                "Figuras: "+this.figuras);
    }

}