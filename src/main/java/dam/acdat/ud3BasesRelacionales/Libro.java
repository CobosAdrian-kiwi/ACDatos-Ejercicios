package dam.acdat.ud3BasesRelacionales;

public class Libro {
    private int id;
    private String titulo;
    private Long isbn;
    private Integer anioPublicacion;
    private Integer ejemplares;
    private Integer disponibles;
    private Integer editorial;

    public Libro(int id, String titulo, Long isbn, Integer anioPublicacion, Integer ejemplares, Integer disponibles, Integer editorial) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.ejemplares = ejemplares;
        this.disponibles = disponibles;
        this.editorial = editorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        this.disponibles = disponibles;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Integer getEditorial() {
        return editorial;
    }

    public void setEditorial(Integer editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return  "ID: " + id + " | Titulo: " + titulo + " | ISBN: " + isbn + " | Año de publicacion: " + anioPublicacion
                + " | Ejemplares totales: " + ejemplares + " | Ejemplares disponibles: " + disponibles;
    }
}
