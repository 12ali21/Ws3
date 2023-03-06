import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit=false;

        PhoneBook phoneBook = new PhoneBook();

        String contactGroup;
        String contactEmail;
        String contactCountryCode;
        String contactPhoneNumber;
        String contactCountry;
        String contactCity;
        String contactZipCode;




        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            if(commands[0].equals("exit")){
                exit = true;
                continue;
            }
            if(commands[0].equals("contacts")){
                if(commands[1].equals("-a")){
                    System.out.println("Please enter contact's group");
                    contactGroup= scanner.nextLine();
                    System.out.println("Please enter contact's email");
                    contactEmail= scanner.nextLine();
                    System.out.println("Please enter contact's country code");
                    contactCountryCode= scanner.nextLine();
                    System.out.println("Please enter contact's phone number");
                    contactPhoneNumber= scanner.nextLine();
                    System.out.println("Please enter contact's zip code");
                    contactZipCode= scanner.nextLine();
                    System.out.println("Please enter contact's country");
                    contactCountry= scanner.nextLine();
                    System.out.println("Please enter contact's city");
                    contactCity= scanner.nextLine();
                    Address address= new Address(contactZipCode,contactCountry,contactCity);
                    PhoneNumber phoneNumber= new PhoneNumber(contactCountryCode,contactPhoneNumber);

                    Contact contact= new Contact(contactGroup,contactEmail,commands[2],commands[3],phoneNumber,address);
                    phoneBook.addContact(contact);

                }
                else if(commands[1].equals("-r")){
                    if(phoneBook.findContact(commands[2],commands[3])==null){
                        System.out.println("Not Found!!!!!");
                    }else {
                        phoneBook.deleteContact(commands[2], commands[3]);
                        System.out.println("Ok :)");

                    }

                }
            }else if(commands[0].equals("show")){
                if(commands.length == 1){
                    phoneBook.printContacts();
                }
                else if(commands[1].equals("-g")){
                    Contact[] groupContacts=phoneBook.findContacts(commands[2]);
                    for (int i = 0; i < groupContacts.length; i++) {
                        if(groupContacts[i] == null)
                            break;
                        System.out.print("contact "+(i+1)+" Name :"+groupContacts[i].firstName+" "+ groupContacts[i].lastName);
                        System.out.print(" PhoneNumber :"+groupContacts[i].phoneNumber.toString());
                        System.out.println(" Address :"+groupContacts[i].address.toString());
                    }
                }
                else if (commands[1].equals("-c")){
                    Contact unique= phoneBook.findContact(commands[2],commands[3]);
                    if(unique==null){
                        System.out.println("Not found!!!");
                    }else{
                        System.out.print("Name :"+unique.firstName+" "+ unique.lastName);
                        System.out.print(" PhoneNumber :"+unique.phoneNumber.toString());
                        System.out.println(" Address :"+unique.address.toString());
                    }

                }
            }


        }

    }
}
