package br.unitins.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CategoriaLivro {

    FICCAO( 1 , "Ficcao" ),
    NAO_FICCAO( 2 , "Nao_ficcao" ),
    ROMANCE( 3 , "Romance" ),
    FANTASIA(  4, "Fantasia" ),
    TERROR(  5,"Terror" ),
    SCI_FI(  6, "Sci_fi" ),
    BIOGRAFIA( 7 , "Biografia" ),
    AUTO_AJUDA(  8, "Auto_ajuda" ),
    POESIA(  9, "Poesia" ),
    HISTORIA(  10,  "Historia");


    private int id;
    private String label;

    CategoriaLivro(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static CategoriaLivro valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(CategoriaLivro categoriaLivro : CategoriaLivro.values()) {
            if (id.equals(categoriaLivro.getId()))
                return categoriaLivro;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }
    }
