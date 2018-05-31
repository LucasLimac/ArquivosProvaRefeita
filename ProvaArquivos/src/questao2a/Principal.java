/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2a;

import java.io.RandomAccessFile;
import questao1a.lerArquivo;

/**
 *
 * @author Lucas Lima
 */
public class Principal {
    public static void main(String[] args) {
        try {
           

            RandomAccessFile f = new RandomAccessFile("arq1questao2a.dat", "r");
            RandomAccessFile f2 = new RandomAccessFile("arq2questao2a.dat", "rw");


            long ultimoRegistro = (f.length() / 102) - 1;
            long primeiro = 0;

            while (ultimoRegistro >= primeiro) {
                lerArquivo e = new lerArquivo();
                f.seek(ultimoRegistro*102);
                e.leRegistro(f);
                if(terminaCom(e.getEmail(),"gmail.com"))
                    e.escreveRegistro(f2);
                ultimoRegistro--;

            }

            f.close();
            f2.close();

        } catch (Exception e) {
            System.err.println("Foi encontrado algum erro no sistema.\n");
            System.exit(1);
        }
    }
    
    public static boolean terminaCom(String email, String termina){
        return email.contains(termina);
    }
    
}
