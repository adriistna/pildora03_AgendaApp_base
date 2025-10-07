package org.ulpgc.is1.model;

public class Address {
    private String street;
    private int number;
    private int floor;
    private String city;

    public Address(String street, int number, int floor, String city) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.city = city;
    }

    public String getStreet() { return street; }
    public int getNumber() { return number; }
    public int getFloor() { return floor; }
    public String getCity() { return city; }

    public void setStreet(String street) { this.street = street; }
    public void setNumber(int number) { this.number = number; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        String floorTxt = (floor > 0) ? (", floor " + floor) : "";
        return street + " " + number + floorTxt + ", " + city;
    }
}
