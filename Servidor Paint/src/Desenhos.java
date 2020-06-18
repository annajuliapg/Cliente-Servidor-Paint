import java.util.*;

//DAO - tabela inteira

public class Desenhos extends Comunicado
{
    private ArrayList<Desenho> desenhos;
    
    public Desenhos ()
    {
        desenhos = new ArrayList<Desenho> ();
    }
    
    public void addDesenho (Desenho novo)
    {
        desenhos.add(novo);
    }
    
    public double getQuantidade ()
    {
        return desenhos.size();
    }
    
    public Desenho getDesenho (int i)
    {
        return desenhos.get(i);
    }

    //metodo incluir
    //metodo incluir mais desenhos
    //metodo alterar
}
