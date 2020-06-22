package Comunica;

import java.net.*;
import java.util.*;

public class Desenho extends Comunicado
{
    private String nomeDesenho;
    private String idCliente;
    private String dataCriacao;
    private String dataModificacao;
    private ArrayList<String> figuras;
    
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
    
    public Desenho (String nomeDesenho, String idCliente, String dataCriacao, String dataModificacao) throws Exception
    {
        this.setNomeDesenho (nomeDesenho);
        this.setIdCliente (idCliente);
        this.setDataCriacao (dataCriacao);
        this.setDataModificacao (dataModificacao);
        
        this.figuras = new ArrayList<String>();
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
    
    public String toString ()
    {
        return ("Nome do Desenho: "+this.nomeDesenho+"\n"+
                "Ip do Cliente: "+this.idCliente+"\n"+
                "Data da Criação: "+this.dataCriacao+"\n"+
                "Data da Modificação: "+this.dataModificacao+"\n"+
                "Figuras: "+this.figuras);
    }

}