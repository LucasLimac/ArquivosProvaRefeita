/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3a;

import java.io.RandomAccessFile;
import questao1a.lerArquivo;

/**
 *
 * @author Lucas Lima
 */
public class questao3a {

    public static void main(String[] args) throws Exception {

        RandomAccessFile f = new RandomAccessFile("arq1questao3a.dat", "r");
        RandomAccessFile f2 = new RandomAccessFile("arq2questao3a.dat", "r");
        RandomAccessFile f3 = new RandomAccessFile("arq3questao3a.dat", "rw");

        long ultimoRegistro = (f.length() / 102) - 1;
        long primeiro = 0;
        System.out.println(f.length() + "" + f2.length());

        while (ultimoRegistro != primeiro) {
            lerArquivo e = new lerArquivo();

            f.seek(ultimoRegistro * 102);

            e.leRegistro(f);

            boolean teste = buscaBinariaRecursiva(f2, 0, ultimoRegistro, e.getChave());
            if (teste) {
                
                
                e.escreveRegistro(f3);
                
            }

            ultimoRegistro--;

        }

        f.close();
        f2.close();
        f3.close();

    }

    public static boolean buscaBinariaRecursiva(RandomAccessFile dados, long esq, long dir, String chave) throws Exception {
        long meio = (esq + dir) / 2;
        lerArquivo ler = new lerArquivo();

        System.out.println("CHAVE LINHA ATUAL-->>>" + chave);
        dados.seek(meio * 102);

        ler.leRegistro(dados);

        System.out.println("------" + ler.getChave() + ler.getNome() + ler.getEmail() + ler.getTelefone());

        String chaveLinhaAtual = ler.getChave();

        int a = Integer.parseInt(chaveLinhaAtual);
        int b = Integer.parseInt(chave);

        if (esq > dir) {
            return false;
        } else if (chaveLinhaAtual.equals(chave)) {
            System.out.println("É IGUAL "+chaveLinhaAtual+"====="+chave );
            return true;

        } else if (a < b) {
            return buscaBinariaRecursiva(dados, meio + 1, dir, chave);

        } else {
            return buscaBinariaRecursiva(dados, esq, meio - 1, chave);
        }
    }
}
