package org.ulpgc.is1.model;

import java.util.List;
import java.util.ArrayList;

public class Agenda {
    private final List<Contact> contacts = new ArrayList<>();
    private final List<Group> groups = new ArrayList<>();

    public Person addPerson(String firstName, String lastName,
                            String telephone, String email,
                            String street, int number, int floor, String city) {
        Address address = new Address(street, number, floor, city);
        Person p = new Person(firstName, lastName, telephone, email, address);
        contacts.add(p);
        return p;
    }

    public Company addCompany(String name, String description,
                              String telephone, String email,
                              String street, int number, int floor, String city) {
        Address address = new Address(street, number, floor, city);
        Company c = new Company(name, description, telephone, email, address);
        contacts.add(c);
        return c;
    }

    public Group addGroup(String name) {
        for (Group g : groups) {
            if (g.getName().equalsIgnoreCase(name)) return g;
        }
        Group g = new Group(name);
        groups.add(g);
        return g;
    }

    public List<Contact> getContactList() { return contacts; }
    public List<Group> getGroupList() { return groups; }

    public int contactCount() { return contacts.size(); }

    public boolean removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            Contact toRemove = contacts.get(index);
            for (Group g : groups) g.removeContact(toRemove);
            contacts.remove(index);
            return true;
        }
        return false;
    }

    public boolean removeGroup(String name) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getName().equalsIgnoreCase(name)) {
                groups.remove(i);
                return true;
            }
        }
        return false;
    }
}
