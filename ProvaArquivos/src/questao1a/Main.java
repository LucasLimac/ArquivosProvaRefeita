/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1a;

import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Lucas Lima
 */
public class Main {

    public static void main(String[] args) {
        try {
           

            RandomAccessFile f = new RandomAccessFile("arq1questao1a.dat", "r");
            RandomAccessFile f2 = new RandomAccessFile("arq2questao1a.dat", "rw");


            long ultimoRegistro = (f.length() / 102) - 1;
            long primeiro = 0;

            while (ultimoRegistro >= primeiro) {
                lerArquivo e = new lerArquivo();
                f.seek(ultimoRegistro*102);
                e.leRegistro(f);
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

}
