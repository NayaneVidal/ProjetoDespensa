package com.example.despensa.Model;

public class AdicionarItensModel {

    private int id;
    private String ean;
    private String nomeProd;
    private String dataValidade;
    private String tvQuantidade;
    private String spnnCategoria;
    private String spnnLocal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdicionarItensModel(String nomeProd, String dataValidade, String tvQuantidade) {
        this.nomeProd = nomeProd;
        this.dataValidade = dataValidade;
        this.tvQuantidade = tvQuantidade;
    }

    public AdicionarItensModel() {

    }

    public String getSpnnLocal() {
        return spnnLocal;
    }

    public void setSpnnLocal(String spnnLocal) {
        this.spnnLocal = spnnLocal;
    }

    public String getSpnnCategoria() {
        return spnnCategoria;
    }

    public void setSpnnCategoria(String spnnCategoria) {
        this.spnnCategoria = spnnCategoria;
    }


    public String getTvQuantidade() {
        return tvQuantidade;
    }

    public void setTvQuantidade(String tvQuantidade) {
        this.tvQuantidade = tvQuantidade;
    }


    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }


    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }


    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }


}
