package org.ulpgc.is1.model;

import java.time.LocalDateTime;

public class Member {
    private final Contact contact;
    private final LocalDateTime date; // fecha y hora de alta

    public Member(Contact contact, LocalDateTime date) {
        this.contact = contact;
        this.date = date;
    }

    public Contact getContact() { return contact; }
    public LocalDateTime getDate() { return date; }
}
