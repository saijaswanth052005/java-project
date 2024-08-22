import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return phoneNumber.equals(contact.phoneNumber); // Assuming phone number uniquely identifies a contact
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Contact [Name=" + name + ", Phone=" + phoneNumber + ", Email=" + email + "]";
    }
}

public class ContactManager {
    private Set<Contact> contactSet;
    private Map<String, Contact> contactMap;

    public ContactManager() {
        contactSet = new HashSet<>();
        contactMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        // Add to Set (to maintain uniqueness)
        if (contactSet.add(contact)) {
            // If added to Set, also add to Map
            contactMap.put(contact.getPhoneNumber(), contact);
        } else {
            System.out.println("Contact with phone number " + contact.getPhoneNumber() + " already exists.");
        }
    }

    public Contact getContactByPhoneNumber(String phoneNumber) {
        // Retrieve contact by phone number from Map
        return contactMap.get(phoneNumber);
    }

    public void removeContactByPhoneNumber(String phoneNumber) {
        Contact contact = contactMap.remove(phoneNumber);
        if (contact != null) {
            contactSet.remove(contact);
            System.out.println("Contact removed: " + contact);
        } else {
            System.out.println("No contact found with phone number " + phoneNumber);
        }
    }

    public void displayAllContacts() {
        System.out.println("All Contacts:");
        for (Contact contact : contactSet) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        Contact c1 = new Contact("Alice", "1234567890", "alice@example.com");
        Contact c2 = new Contact("Bob", "0987654321", "bob@example.com");
        Contact c3 = new Contact("Charlie", "1234509876", "charlie@example.com");

        manager.addContact(c1);
        manager.addContact(c2);
        manager.addContact(c3);

        // Attempt to add a duplicate contact
        manager.addContact(new Contact("Alice", "1234567890", "alice2@example.com"));

        // Display all contacts
        manager.displayAllContacts();

        // Retrieve a contact by phone number
        System.out.println("\nContact with phone number 1234567890:");
        System.out.println(manager.getContactByPhoneNumber("1234567890"));

        // Remove a contact by phone number
        manager.removeContactByPhoneNumber("0987654321");

        // Display all contacts after removal
        manager.displayAllContacts();
    }
}
