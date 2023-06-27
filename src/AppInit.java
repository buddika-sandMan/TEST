import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//SELECT PROJECT AND CLICK CTRL + SHIFT + ALT + U (WE CAN GET UI VIEW OF OUR PROJECT)

public class AppInit {

    //Database area
    //User DB
    static String[][] users = new String[3][2];

    //Customer DB
    static String[][] customers = new String[100][4];

    //Item DB
    static String[][] items = new String[100][4];

    //Order DB
    static  String[][] orders = new String[100][5];


    public static void main(String[] args) {

        //Testing Item array
        items[0][0] = "0001";
        items[0][1] = "Desc 1";
        items[0][2] = "13";
        items[0][3] = "50";

        //Test Order array
        //

        Scanner input = new Scanner(System.in);
        //Initial question list
        String[] initializePageQuestion = {
                "01) Are you new to here?",
                "02) Do you want to login?",
                "03) Do you want to exit the page?"
        };

        //Print initial question list
        for (String initQuetion : initializePageQuestion) {
            System.out.println(initQuetion);
        }

        int userInput = input.nextInt();
        switch (userInput){
            case 1:
                if(register()){
                    openDashboard();
                }
                break;
            case 2:
                if(login()) {
                    openDashboard();
                }
                break;
            case 3: break;
            default:return;// exit
        }
    }

    public static boolean login(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter email");
        String email = input.nextLine();
        System.out.println("Enter password");
        String pwd = input.nextLine();

        for (int i=0; i<users.length; i++){
            if(users[i][0]!=null && users[i][0].equalsIgnoreCase(email)){
                if (users[i][1].equalsIgnoreCase(pwd)){
                    return true;
                }else{
                    System.out.println("Wrong password");
                    return false;
                }
            }
        }
        System.out.println("404");
        return false;

    }

    //Register process
    public static boolean register() {
        Scanner input = new Scanner(System.in);

        //check array element empty or not
        if (users[users.length - 1][0] != null) {
            System.out.println("User database is full!");
            return false;
        } else {
            System.out.println("Enter your email!");
            String email = input.nextLine();
            System.out.println("Enter your password!");
            String pwd = input.nextLine();

            for (int x = 0; x < users.length; x++) {
                if (users[x][0] == null) {
                    users[x][0] = email;
                    users[x][1] = pwd;

                    System.out.println("Record saved!");
                    return true;
                } else {
                    if (users[x][0].equalsIgnoreCase(email)) {
                        System.out.println("Email is already exists!");
                        return false;
                    }
                }
            }

        }
        return false;
    }

    //dashboard area
    public static void openDashboard(){
        Scanner input = new Scanner(System.in);

        String openDashboardQuestion[] = {
                "1) Customer Management",
                "2) Item Management",
                "3) Order Management",
                "4) Logout"
        };

        while (true){
            for (String question:openDashboardQuestion
                 ) {
                System.out.println(question);
            }
            int userInput = input.nextInt();

            switch (userInput){
                case 1:
                    customerManagment();
                    break;
                case 2:
                    //itemManagement();
                    break;
                case 3:
                    newOrder();
                    break;
                case 4:
                    break;
                default: return;
            }
        }
    }

    //Customer management process
    public static void customerManagment(){
        Scanner input = new Scanner(System.in);

        String dashboardQuestion[] = {
                "1) Save Customer",
                "2) Find Customer",
                "3) Update Customer",
                "4) Delete Customer",
                "5) Find All Customer",
                "6) Back to Home"
        };

        while (true){
            for (String question:dashboardQuestion
                 ) {
                System.out.println(question);
            }
            int userInput = input.nextInt();

            switch (userInput){
                case 1:
                    saveCustomer();
                    break;
                case 2:
                    findCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    findAllCustomer();
                    break;
                case 6:
                    return;
                default:return;
            }
        }
    }

    //Save new customer
    public static void saveCustomer(){
        Scanner input = new Scanner(System.in);

        while (true){
            String id, name, address;
            double salary;

            System.out.println("Insert customer NIC");
            id = input.nextLine();
            System.out.println("Insert customer name");
            name = input.nextLine();
            System.out.println("Insert customer address");
            address = input.nextLine();
            System.out.println("Insert customer salary");
            salary = input.nextDouble();

            customerForLoop://lable for loop
            for (int i = 0; i < customers.length; i++){
                if (customers[i][0]!=null){
                    if (customers[i][0].equalsIgnoreCase(id)){
                        System.out.println("Customer already exists!");
                        break;
                    }
                }else{
                    customers[i][0] = id;
                    customers[i][1] = name;
                    customers[i][2] = address;
                    customers[i][3] = String.valueOf(salary);

                    System.out.println("Csutomer Saved!\n");
                    System.out.println("1) Do you want add another Customer\n");
                    System.out.println("2) Back to manu");

                    int option = input.nextInt();

                    switch (option){
                        case 1:
                            saveCustomer();
                            break; //customerForLoop;
                        case 2:
                            return;
                        case 3:
                            return;
                    }
                }
            }
        }
    }

    //Find customer
    public static void findCustomer(){
        Scanner input = new Scanner(System.in);

        System.out.println("Insert NIC");
        String nic = input.nextLine();

        for (int i = 0; i < customers.length; i++){
            if(customers[i][0]!=null){
                if(customers[i][0].equals(nic)){
                    System.out.println("Customer NIC : " + customers[i][0]);
                    System.out.println("Customer Name : " + customers[i][1]);
                    System.out.println("Customer Address : " + customers[i][2]);
                    System.out.println("Customer Salary : " + customers[i][3]);
                    return;
                }else {
                    System.out.println("Customer not found!");
                }
            }
        }
    }

    //Update customer
    public static void updateCustomer() {
        Scanner input = new Scanner(System.in);

        System.out.println("Find customer");
        String nic = input.nextLine();

        for (int i = 0; i < customers.length; i++) {
            if (customers[i][0] != null) {
                if (customers[i][0].equalsIgnoreCase(nic)) {

                    String updateName, updateAddress;
                    double updateSalary;

                    System.out.println("Customer NIC : " + customers[i][0]);
                    System.out.println("Customer Name : " + customers[i][1]);
                    System.out.println("Customer Address : " + customers[i][2]);
                    System.out.println("Customer Salary : " + customers[i][3]);

                    System.out.println("Update customer name");
                    updateName = input.nextLine();
                    System.out.println("Update customer address");
                    updateAddress = input.nextLine();
                    System.out.println("Update customer salary");
                    updateSalary = input.nextDouble();

                    customers[i][1] = updateName;
                    customers[i][2] = updateAddress;
                    customers[i][3] = String.valueOf(updateSalary);
                    System.out.println("Customer data updated!");
                    break;
                }

            }

        }
    }

    //Delete customer
    public static void deleteCustomer(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter delete customer NIC");
        String nic =  input.nextLine();

        for (int i = 0; i < customers.length; i++){
            if(customers[i][0].equalsIgnoreCase(nic)){

                String deleteId, deleteName, deleteAddress;
                double deleteSalary;

                System.out.println("Customer NIC : " + customers[i][0]);
                System.out.println("Customer Name : " + customers[i][1]);
                System.out.println("Customer Address : " + customers[i][2]);
                System.out.println("Customer Salary : " + customers[i][3]);

                System.out.println("Do you want delete this customer? 1)YES | 2)NO");
                int yesNo = input.nextInt();

                switch (yesNo){
                    case 1:
                        customers[i][0] = null;
                        customers[i][1] = null;
                        customers[i][2] = null;
                        customers[i][3] = null;

                        System.out.println("Delete successful!");
                        return;
                    case 2:
                        return;
                    default:
                        return;
                }

            }
        }
    }

    //Find all customer
    public static void findAllCustomer(){
        for (int i = 0; i < customers.length; i++){
            if(customers[i][0].equals(null)){
                System.out.println("NIC : " + customers[i][0] + "\tName : " + customers[i][1] +
                        "\tAddress : " + customers[i][2] + "\tSalary : " + customers[i][3]);
            }else {
                System.out.println("Customer database is empty");
                return;
            }

        }
    }

    //Order management process
    public static void newOrder(){
        Scanner input = new Scanner(System.in);

        System.out.println("Insert customer NIC");
        String nic = input.nextLine();

        String name, address;
        double salary;

        //Find customer
        for (int i = 0; i < customers.length; i++) {
            if (customers[i][0] != null) {
                if (customers[i][0].equals(nic)) {
                    name = customers[i][1];
                    address = customers[i][2];
                    salary = Double.parseDouble(customers[i][3]);
                }
            }
        }

        System.out.println("Enter the item code");
        String code = input.nextLine();

        String description;
        double unitPrice = 0;
        int qtyHand;

        //Item find
        for (int i = 0; i < items.length; i++){
            if(items[i][0]!=null){
                if(items[i][0].equals(code)){
                    description = items[i][1];
                    unitPrice = Double.parseDouble(items[i][2]);//Wrapper class
                    qtyHand = Integer.parseInt(items[i][3]);
                }
            }

    }
        System.out.println("Enter order id");
        String orderId = input.nextLine();

        // Order find
        for (int i = 0; i < orders.length; i++){
            if(orders[i][0] != null){
                if(orders[i][0].equals(orderId)){
                    System.out.println("Order ID exists!");
                    return;
                }else {
                    Date date = new Date();
                    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                    String selectDate = f.format(date);
                    orders[i][0] = orderId;
                    orders[i][1] = nic;
                    orders[i][2] = code;
                    orders[i][3] = selectDate;
                    orders[i][4] = String.valueOf(unitPrice);
                }
            }
        }
        System.out.println("Order completed!");
    }
}