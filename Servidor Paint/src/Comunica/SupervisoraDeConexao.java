package Comunica;

import BancoDeDados.RegistroDesenho;
import BancoDeDados.RegistroDesenhos;
import java.io.*;
import java.net.*;
import java.util.*;

public class SupervisoraDeConexao extends Thread
{
    private double              valor=0;
    private Parceiro            usuario;
    private Socket              conexao;
    private ArrayList<Parceiro> usuarios;

    public SupervisoraDeConexao
    (Socket conexao, ArrayList<Parceiro> usuarios)
    throws Exception
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.conexao  = conexao;
        this.usuarios = usuarios;
    }

    public void run ()
    {
        ObjectOutputStream transmissor;
        try
        {
            transmissor =
            new ObjectOutputStream(
            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            return;
        }
        
        ObjectInputStream receptor=null;
        try
        {
            receptor=
            new ObjectInputStream(
            this.conexao.getInputStream());
        }
        catch (Exception err0)
        {
            try
            {
                transmissor.close();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread
            
            return;
        }

        try
        {
            this.usuario =
            new Parceiro (this.conexao,
                          receptor,
                          transmissor);
        }
        catch (Exception erro)
        {} // sei que passei os parametros corretos

        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }

            for(;;)
            {
                Comunicado comunicado = this.usuario.envie ();

                if (comunicado==null)
                    return;
                else if (comunicado instanceof PedidoDeSalvamento)
                {
                    PedidoDeSalvamento pedidoDeSalvamento = (PedidoDeSalvamento)comunicado;
                    
                    pedidoDeSalvamento.getDesenho();
                    
                    System.out.println(pedidoDeSalvamento.toString());
                    
                    try
                    {
                    
                    RegistroDesenhos.incluir(new RegistroDesenho (pedidoDeSalvamento.getNomeDesenho(),
                                                                  pedidoDeSalvamento.getIdCliente(),          
                                                                  pedidoDeSalvamento.getDataCriacao(),
                                                                  pedidoDeSalvamento.getDataModificacao()));
                    
                        System.out.println("\n\nDEU CERTO");
                    
                    }
                    catch (Exception erro)
                    {
                                    erro.printStackTrace();
                        System.out.println (erro.getMessage());
                    }
                    
                    //Formas.incluir(new Forma ())
                    
					
                    
                }
                else if (comunicado instanceof PedidoDeAbertura)
                {
                    
                }
            }
        }
        catch (Exception erro)
        {
            try
            {
                transmissor.close ();
                receptor   .close ();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread

            return;
        }
    }
}
