package org.ulpgc.is1.model;

public class Person extends Contact {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName,
                  String telephone, String email, Address address) {
        super(telephone, email, address);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }
}
