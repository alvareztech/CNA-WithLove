package tech.alvarez.withlove.model;

import java.util.List;

public class Album {

    private List<Foto> fotos;

    public Album(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
}
