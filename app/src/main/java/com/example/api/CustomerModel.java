package com.example.api;

public class CustomerModel {

    private int def_id;
    private String definition;

    //

    public CustomerModel() {
        this.def_id = def_id;
        this.definition = definition;
    }

    public CustomerModel(int customerID, String customerDef) {
        this.def_id = customerID;
        this.definition = customerDef;
    }

    //To String (for the context)

    @Override
    public String toString() {
        return "CustomerModel{" +
                ", def_id=" + def_id +
                ", definition='" + definition + '\'' +
                '}';
    }

    //Getters and Setters

    public int getDef_id() { return def_id; }

    public void setDef_id(int def_id) { this.def_id = def_id; }

    public String getDefinition() { return definition; }

    public void setDefinition(String definition) { this.definition = definition; }
}
