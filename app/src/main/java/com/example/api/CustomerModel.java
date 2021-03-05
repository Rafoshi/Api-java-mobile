package com.example.api;

public class CustomerModel {

    private String word;
    private int def_id;
    private String definition;
    private String permalink;
    private String example;

    //

    public CustomerModel(String word, int def_id, String definition, String permalink, String example) {
        this.word = word;
        this.def_id = def_id;
        this.definition = definition;
        this.permalink = permalink;
        this.example = example;
    }

    //To String (for the context)

    @Override
    public String toString() {
        return "CustomerModel{" +
                "word='" + word + '\'' +
                ", def_id=" + def_id +
                ", definition='" + definition + '\'' +
                ", permalink='" + permalink + '\'' +
                ", example='" + example + '\'' +
                '}';
    }

    //Getters and Setters

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDefid() {
        return def_id;
    }

    public void setDefid(int defid) {
        this.def_id = def_id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
