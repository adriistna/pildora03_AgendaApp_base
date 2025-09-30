package org.ulpgc.is1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private final List<Member> members = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    // Agrega un contacto al grupo con fecha de alta = hoy. Evita duplicados por Contact.
    public void addContact(Contact contact) {
        for (Member m : members) {
            if (m.getContact().equals(contact)) {
                return; // ya está en el grupo
            }
        }
        members.add(new Member(contact, LocalDate.now()));
    }

    // Elimina por índice (tal y como usas en el Main).
    public void removeContact(int index) {
        if (index >= 0 && index < members.size()) {
            members.remove(index);
        }
    }

    public int contactCount() {
        return members.size();
    }

    public Member getMember(int index) {
        if (index < 0 || index >= members.size()) {
            throw new IndexOutOfBoundsException("Member index out of range: " + index);
        }
        return members.get(index);
    }

    public List<Member> getMembers() {
        return members; // si prefieres inmutable: return List.copyOf(members);
    }
}