package br.unitins.model;


import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoPagamento {


    BOLETO(1, "Boleto"),

    CARTAO(2, "Cartão"),

    PIX(3, "Pix");

    private int id;
    private String label;

    TipoPagamento(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoPagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(TipoPagamento tipoPagamento : TipoPagamento.values()) {
            if (id.equals(tipoPagamento.getId()))
                return tipoPagamento;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
