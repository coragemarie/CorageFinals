
package coragefinals;

import java.util.Scanner;
import java.util.Set;

public class CorageFinals {

    public static void main(String[] args) {
        ExamGraphClass egc = new ExamGraphClass();
        Scanner scn = new Scanner(System.in);

        System.out.println("Social Network System:");
        System.out.println("Press 1 to Add User");
        System.out.println("Press 2 to Add Friend");
        System.out.println("Press 3 to Display All Friends");
        System.out.println("Press 4 to Get Recommended Friends");
        System.out.println("Press 5 to Exit");

        while (true) {
            System.out.print("\nEnter a choice: ");
            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name of the user to add: ");
                    String user = scn.nextLine();
                    egc.addUserName(user);
                    System.out.println("User " + user + " is added.");
                    break;

                case 2:
                    System.out.print("Name of the user: ");
                    String user1 = scn.nextLine();
                    System.out.print("Name of the the friend to add: ");
                    String user2 = scn.nextLine();
                    egc.addFriendName(user1, user2);
                    System.out.println("Friendship added between " + user1 + " and " + user2 + ".");
                    break;

                case 3:
                    System.out.println("All users and their friends:");
                    egc.displayAllFriends();
                    break;

                case 4:
                    System.out.print("Name of the user to get recommendations for: ");
                    String targetUser = scn.nextLine();
                    Set<String> friendsReco = egc.getRecommendedFriendsNames(targetUser);
                    if (friendsReco.isEmpty()) {
                        System.out.println("No recommended friends for " + targetUser + ".");
                    } else {
                        System.out.println("Recommended friends for " + targetUser + ": " + friendsReco);
                    }
                    break;

                case 5:
                    System.out.println("Exit");
                    scn.close();
                    return;

                default:
                    System.out.println("YOU ENTER A WRONG CHOICE, PLEASE TRY AGAIN.");
            }
        }
    }
 }
    

