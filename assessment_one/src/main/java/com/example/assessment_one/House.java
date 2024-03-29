package com.example.assessment_one;

public class House {

    //private fields/attributes
    private String owner;
    private String address;
    private int noBedrooms;


    //public constructor from fields
    public House(String owner, String address, int noBedrooms) {
        super();

        //uses jsp default values if input is null
        if (owner.isEmpty()) {
            this.owner = null;
        } else {
            this.owner = owner;
        }

        if (address.isEmpty()) {
            this.address = null;
        } else {
            this.address = address;
        }

        this.noBedrooms = noBedrooms;
    }

    //public setters and getters
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoBedrooms() {
        return noBedrooms;
    }

    public void setNoBedrooms(int noBedrooms) {
        this.noBedrooms = noBedrooms;
    }
}
