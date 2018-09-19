package com.example.lomba.firstproject;

public class Category {
    private String name;

    private Category(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category HUMOUR = new Category("Humour");
    public static Category HORREUR = new Category("Horreur");
    public static Category ROMANCE = new Category("Romance");
    public static Category COMEDIE = new Category("Comédie");
    public static Category ACTION = new Category("Action");
    public static Category AVENTURE = new Category("Aventure");
    public static Category GUERRE = new Category("Guerre");
    public static Category DOCUMENTAIRES = new Category("Documentaires");
    public static Category POLICIER = new Category("Policier");
    public static Category SCIENCEFICTION = new Category("Science-fiction");
    public static Category WESTERN = new Category("Western");
    public static Category BIOPIC = new Category("Biopic");
    public static Category MANGAS = new Category("Mangas");
    public static Category ANIMATION = new Category("Animation");
    public static Category COMEDIEM = new Category("Comédie musicale");
    public static Category TOUTES = new Category("Toutes les catégories");

}
