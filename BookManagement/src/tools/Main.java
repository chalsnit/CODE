/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import core.BooksMa;
import core.PublishersMa;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author nghia
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BooksMa bM = new BooksMa();
        PublishersMa pM = new PublishersMa();
        MyUtil mu = new MyUtil();

        Scanner sc = new Scanner(System.in);

        Vector<String> options = new Vector<>();

        options.add("1.[Publisher] Create a Publisher");
        options.add("2.[Publisher] Delete a Publisher");
        options.add("3.[Publisher] Save the Publishers list to file");
        options.add("4.[Publisher] Print the Publishers list from file");
        options.add("5.[Book] Create a Book");
        options.add("6.[Book] Search the book");
        options.add("7.[Book] Update the book");
        options.add("8.[Book] Delete the book");
        options.add("9.[Book] Save the books list to file");
        options.add("10.[Book] Print the books list from file");
        options.add("11. Others - Quit\n");

        int choice = 0;
        pM.inputPublisherList();
        bM.inputBooksList();

        do {

            System.out.println("\nWelcome to Book Store Management ");

            for (int i = 0; i < options.size(); i++) {
                System.out.println(options.get(i));
            }
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    pM.createAPublisher();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 2:
                    pM.deleteThePublisher();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 3:
                    pM.savePublisherToFile();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 4:
                    pM.printPublisherList();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 5:
                    bM.createABook();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 6:
                    bM.searchBook();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 7:
                    bM.updateBook();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 8:
                    bM.deleteBook();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 9:
                    bM.saveBooksToFile();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                case 10:
                    bM.printALFF();
                    if (!mu.askToMain()) {
                        choice = 11;
                    }
                    break;
                default:
                    System.out.println("Bye!");
            }

        } while (choice > 0 && choice < 11);
    }
}
