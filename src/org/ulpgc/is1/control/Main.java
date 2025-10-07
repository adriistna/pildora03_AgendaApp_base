package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // 1. Crear dos contactos Person
        agenda.addPerson("John", "Doe", "123456789", "john.doe@example.com",
                "Main Street", 123, 4, "Anytown");
        agenda.addPerson("Jane", "Doe", "987654321", "jane.doe@example.com",
                "Other Street", 456, 1, "Othertown");

        // 2. Crear un grupo llamado "trabajo"
        Group trabajoGroup = agenda.addGroup("trabajo");

        // 3. Añadir al grupo “trabajo” uno de los contactos creados
        Contact contactToAdd = agenda.getContactList().get(0);
        trabajoGroup.addContact(contactToAdd);

        // 4. Imprimir el número de contactos de la agenda
        System.out.println("Número de contactos en la agenda: " + agenda.contactCount());

        // 5. Imprimir el número de contactos del grupo “trabajo”
        System.out.println("Número de contactos en el grupo 'trabajo': " + trabajoGroup.contactCount());

        // 6. Imprimir la fecha de alta del miembro en el grupo (apartado b)
        Member member = trabajoGroup.getMember(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Fecha de alta en el grupo: " + member.getDate().format(formatter));

        // 7. Borrar el primer contacto del grupo “trabajo”
        trabajoGroup.removeContact(0);

        // 8. Volver a imprimir el número de contactos del grupo “trabajo”
        System.out.println("Número de contactos en el grupo 'trabajo' después de borrar: "
                + trabajoGroup.contactCount());
    }
}
