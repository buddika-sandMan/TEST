import java.util.Scanner;

public class AppInit {

    //Database area
    static String[][] users = new String[3][2];

    public static void main(String[] args) {

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
        System.out.println("dashboard");
    }
}