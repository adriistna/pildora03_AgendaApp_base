package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Contact> contacts = new ArrayList<>();
    private final List<Group> groups = new ArrayList<>();

    // Person
    public Person addPerson(String firstName, String lastName,
                            String telephone, String email,
                            String street, int number, int floor, String city) {

        Address address = new Address(street, number, floor, city);
        Person candidate = new Person(firstName, lastName, telephone, email, address);

        Contact existing = findByName(candidate.getName());
        if (existing == null) {
            contacts.add(candidate);
            return candidate;
        } else {
            // ya existe persona con ese nombre; devolvemos la existente
            return (Person) existing;
        }
    }

    // Company (por si lo necesitas en la 2ª parte)
    public Company addCompany(String name, String description,
                              String telephone, String email,
                              String street, int number, int floor, String city) {

        Address address = new Address(street, number, floor, city);
        Company candidate = new Company(name, description, telephone, email, address);

        Contact existing = findByName(candidate.getName());
        if (existing == null) {
            contacts.add(candidate);
            return candidate;
        } else {
            return (Company) existing;
        }
    }

    public Group addGroup(String name) {
        // Evita grupos duplicados por nombre
        for (Group g : groups) {
            if (g.getName().equalsIgnoreCase(name)) {
                return g;
            }
        }
        Group g = new Group(name);
        groups.add(g);
        return g;
    }

    public List<Contact> getContactList() {
        return contacts; // si prefieres inmutable: return List.copyOf(contacts);
    }

    public List<Group> getGroupList() {
        return groups;
    }

    public int contactCount() {
        return contacts.size();
    }

    private Contact findByName(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}