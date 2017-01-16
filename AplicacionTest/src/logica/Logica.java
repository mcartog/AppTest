/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Tema;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author marcostoral
 */
public class Logica {
    private List<Tema> listaTemas = new ArrayList<Tema>();
    private List<String> listaRespuestas = new ArrayList<String>();
    private List<String> listaSoluciones = new ArrayList<String>();
    
    int aciertos, enBlanco, errores;

    public List<Tema> getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(List<Tema> listaTemas) {
        this.listaTemas = listaTemas;
    }

    public List<String> getListaRespuestas() {
        return listaRespuestas;
    }

    public void setListaRespuestas(List<String> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

    public List<String> getListaSoluciones() {
        return listaSoluciones;
    }

    public void setListaSoluciones(List<String> listaSoluciones) {
        this.listaSoluciones = listaSoluciones;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getEnBlanco() {
        return enBlanco;
    }

    public void setEnBlanco(int enBlanco) {
        this.enBlanco = enBlanco;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }
    
      /**
     * Añade un tema a la lista de temas.
     *
     * @param tema
     */
    public void aniadirTemaLista(Tema tema) {
        listaTemas.add(tema);
    }

    /**
     * Muestra las respuestas del test.
     *
     * @param listaRespuestas
     */
    public void muestraRespuesta(List<String> listaRespuestas) {
        if (listaRespuestas.isEmpty() == true) {
            System.out.println("No se ha contestado ninguna pregunta.");
        } else {
            for (int i = 0; i < listaRespuestas.size(); i++) {
                System.out.println((i + 1) + " " + listaRespuestas.get(i).toString());
            }
        }

    }
    
      /**
     * Metodo para la lectura y carga de temas.
     *
     * @param ruta Ruta del fichero csv.
     */
    public void leeTemas(String ruta) {
        FileReader fr = null;
        try {
            fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while (cadena != null) {
                tokenizarTema(cadena);
                cadena = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

    private void tokenizarTema(String linea) {
        StringTokenizer tokens = new StringTokenizer(linea, ".");
        while (tokens.hasMoreTokens()) {
            Tema t = new Tema(tokens.nextToken());
            aniadirTemaLista(t);
        }

    }
    
}
