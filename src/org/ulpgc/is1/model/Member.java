package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Member {
    private final Contact contact;
    private final LocalDate date;

    public Member(Contact contact, LocalDate date) {
        this.contact = contact;
        this.date = date;
    }

    public Contact getContact() { return contact; }
    public LocalDate getDate() { return date; }
}