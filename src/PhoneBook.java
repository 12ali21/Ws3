public class PhoneBook {


    Contact[] contacts;
    int currLength = 0;

    public PhoneBook() {
        contacts = new Contact[20];
    }

    Contact findContact(String firstName, String lastName) {
        for (int i = 0; i < currLength; i++) {
            if (contacts[i].firstName.equals(firstName)) {
                if (contacts[i].lastName.equals(lastName)) {
                    return contacts[i];
                }
            }
        }
        return null;

    }

    boolean addContact(Contact contact) {
        if (findContact(contact.firstName, contact.lastName) == null) {
            contacts[currLength++] = contact;
            return true;
        } else
            return false;

    }

    boolean deleteContact(String firstName, String lastName) {
        if (findContact(firstName, lastName) == null) {
            return false;
        } else {
            boolean foundContact = false;
            for (int i = 0; i < currLength; i++) {
                if (contacts[i].firstName.equals(firstName)) {
                    if (contacts[i].lastName.equals(lastName)) {
                        foundContact = true;
                    }
                }
                if (foundContact) {
                    contacts[i] = contacts[i + 1];
                }
            }
            contacts[currLength - 1] = null;
            currLength--;
            return true;


        }

    }

    Contact[] findContacts(String group){
        Contact[] foundGroup = new Contact[20];
        int indexGroup=0;
        for (int i = 0; i < currLength; i++) {
            if(contacts[i].group.equals(group)){
                foundGroup[indexGroup++]=contacts[i];
            }
        }
        if(indexGroup==0){
            return null;
        }
        return foundGroup;
    }
    void printContacts(){
        for (int i = 0; i < currLength; i++) {
            System.out.print("contact "+i+" Name :"+contacts[i].firstName+" "+ contacts[i].lastName);
            System.out.print(" PhoneNumber :"+contacts[i].phoneNumber.toString());
            System.out.println(" Address :"+contacts[i].address.toString());

        }

    }
}
