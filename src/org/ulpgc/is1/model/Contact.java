package org.ulpgc.is1.model;

public abstract class Contact {
    private String telephone;
    private String email;
    private Address address;

    protected Contact(String telephone, String email, Address address) {
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public abstract String getName();

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    // Igualdad por nombre lógico del contacto (para evitar duplicados por nombre completo)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact other = (Contact) o;
        return this.getName().equalsIgnoreCase(other.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return getName() + " (" + telephone + ", " + email + ")";
    }
}


