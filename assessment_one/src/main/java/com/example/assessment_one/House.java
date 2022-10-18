package com.example.assessment_one;

public class House {

    //private fields/attributes
    private String owner = "";
    private String address = "";
    private int noBedrooms = 0;


    //public constructor from fields
    public House(String owner, String address, String noBedrooms) {
        super();
        if (!owner.isEmpty()) {
            this.owner = null;
        }
        if (!address.isEmpty()) {
            this.address = null;
        }
        if (!noBedrooms.isEmpty()) {
            try {
                this.noBedrooms = Integer.parseInt(noBedrooms);
            } catch (NumberFormatException nfe) {
                System.err.println(nfe.getMessage());
                this.noBedrooms = 0;
            }
        }
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
