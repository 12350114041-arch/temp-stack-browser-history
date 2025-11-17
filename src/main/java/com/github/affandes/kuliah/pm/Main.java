package com.github.affandes.kuliah.pm;

import java.util.Stack;
import java.util.Scanner;

public class BrowserHistory {
    private Stack<String> history = new Stack<>();

    public void browse(String url) {
        history.push(url);
        System.out.println("Opened: " + url);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("No history to go back.");
        } else {
            String last = history.pop();
            System.out.println("Back from: " + last);
            if (!history.isEmpty()) {
                System.out.println("Now at: " + history.peek());
            } else {
                System.out.println("History is now empty.");
            }
        }
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("No browsing history.");
        } else {
            System.out.println("\n=== Browser History (Newest First) ===");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Browse");
            System.out.println("2. Back");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int option = input.nextInt();
            input.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter website URL: ");
                    String url = input.nextLine();
                    browser.browse(url);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.view();
                    break;
                case 4:
                    System.out.println("Exiting browser...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

    
        
