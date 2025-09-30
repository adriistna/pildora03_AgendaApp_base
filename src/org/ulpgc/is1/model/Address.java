package org.ulpgc.is1.model;

public class Address {
    private String street;
    private int number;
    private int floor;      // usa 0 si no aplica
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

    @Override
    public String toString() {
        String floorTxt = (floor > 0) ? (", floor " + floor) : "";
        return street + " " + number + floorTxt + ", " + city;
    }
}