package huruhum.coctelera;


import java.io.Serializable;

public class Formato implements Serializable {
    private String titulo;
    private String subtitulo;
    private int miniatura;
    private int imagen;
    private String descripcion;

    public Formato(String titulo, String subtitulo, int miniatura, int imagen, String descripcion){
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.miniatura = miniatura;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public int getMiniatura(){
        return miniatura;
    }

    public int getImagen(){
        return imagen;
    }

    public String getDescripcion(){
        return descripcion;
    }


}








