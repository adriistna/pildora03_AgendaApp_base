package org.ulpgc.is1.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Group {
    private String name;
    private final List<Member> members = new ArrayList<>();

    public Group(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Guarda contacto con fecha de alta actual
    public void addContact(Contact contact) {
        for (Member m : members) {
            if (m.getContact() == contact) return; // evita duplicado
        }
        members.add(new Member(contact, LocalDateTime.now()));
    }

    public void removeContact(int index) {
        if (index >= 0 && index < members.size()) members.remove(index);
    }

    public void removeContact(Contact contact) {
        members.removeIf(m -> m.getContact() == contact);
    }

    public int contactCount() { return members.size(); }

    public Member getMember(int index) {
        if (index < 0 || index >= members.size()) {
            throw new IndexOutOfBoundsException("Member index out of range: " + index);
        }
        return members.get(index);
    }

    public List<Member> getMembers() { return members; }
}
