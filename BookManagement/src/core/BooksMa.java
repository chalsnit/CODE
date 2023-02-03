package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import static javax.xml.bind.DatatypeConverter.parseInteger;

/**
 *
 * @author nghia
 */
class BookComparator implements Comparator<Books> {

    @Override
    public int compare(Books s1, Books s2) {
        return s1.getBookID().compareTo(s2.getBookID());
    }
}

class BooksComparator implements Comparator<Books> {

    @Override
    public int compare(Books s1, Books s2) {
        if (s1.getQuantity() == s2.getQuantity()) {
            return s1.getBookPrice() > s2.getBookPrice() ? 1 : -1;
        } else {
            return s1.getQuantity() < s2.getQuantity() ? 1 : -1;
        }
    }
}

public class BooksMa extends Books {

    Vector<Books> booksList = new Vector();

    PublishersMa pubM = new PublishersMa();

    public void inputPublishersId() {
        pubM.inputPublisherList();
    }

    public boolean findPubID(String st) {
        PublishersMa pubM = new PublishersMa();
        pubM.inputPublisherList();
        for (int i = 0; i < pubM.publisherList.size(); i++) {

            if (st.matches(pubM.publisherList.get(i).getPublisherId())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPatternBookId(String st, String pattern) {
        return st.matches(pattern);
    }

    public boolean checkLengthMinMax(String st, int min, int max) {
        return !(st.length() < min || st.length() > max);
    }

    public int checkDup(String st) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getBookID().equals(st)) {
                return i;
            }
        }
        return -1;
    }

    public int checkDup(String st, int pos) {
        for (int i = 0; i < booksList.size(); i++) {
            if (pos != i && booksList.get(i).getBookID().equals(st)) {
                return i;
            }
        }
        return -1;
    }

    public void inputBooksList() {
        booksList.clear();
        boolean flag = false;
        do {
            try {
                FileReader fileInput = new FileReader(".\\src\\data\\Books.dat");
                BufferedReader br = new BufferedReader(fileInput);

                String line = br.readLine();
                while (line != null) {
                    StringTokenizer st = new StringTokenizer(line, ",", false);
                    while (st.hasMoreElements()) {
                        String bookID = st.nextToken().trim();
                        if (!checkPatternBookId(bookID, "^B[0-9]{5}$") || checkDup(bookID) >= 0) {
                            System.out.println("\nBook Id already exists or error");
                            throw new Exception();
                        }

                        String bookName = st.nextToken().trim();
                        if (!checkLengthMinMax(bookName, 5, 30)) {
                            System.out.println("\nBook Name is too long or too short");
                            throw new Exception();
                        }

                        Double bookPrice = parseDouble(st.nextToken().trim());
                        if (bookPrice <= 0) {
                            System.out.println("\nBook Price <= 0");
                            throw new Exception();
                        }

                        int quantity = parseInt(st.nextToken().trim());
                        if (quantity < 0) {
                            System.out.println("\nQuantity erorr");
                            throw new Exception();
                        }
                        String publisherId = st.nextToken().trim();
                        if (!findPubID(publisherId)) {
                            System.out.println(publisherId);
                            System.out.println("\nPublisherId not found");
                            throw new Exception();
                        }
                        String status = st.nextToken().trim();
                        if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Not Available")) {
                            System.out.println("\nStatus erorr");
                            throw new Exception();
                        }

                        booksList.add(new Books(bookID, bookName, bookPrice, quantity, publisherId, status));

                        flag = false;
                        line = br.readLine();

                    }
                }

                br.close();
                fileInput.close();
            } catch (Exception e) {
                System.out.println("Please, Check file Books.dat and press ENTER to continue");
                Scanner sc = new Scanner(System.in);
                String tmp = sc.nextLine();
                flag = true;
            }
        } while (flag);
    }

    public void createABook() {

        System.out.println("\n-------------Create a Publisher------------");
        String bookID = "";
        String bookName = "";
        double bookPrice = 0;
        int quantity = 0;
        String publisherID = "";
        String status = "";

        boolean flag = false;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input bookID: ");
                bookID = sc.nextLine().trim();
                if (!checkPatternBookId(bookID, "^B[0-9]{5}$") || checkDup(bookID) >= 0) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nBook Id already exists or error");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input bookname: ");
                bookName = sc.nextLine().trim();
                if (!checkLengthMinMax(bookName, 5, 30)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nBook Name is too long or too short");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input bookPrice: ");
                bookPrice = parseDouble(sc.nextLine().trim());
                if (bookPrice <= 0) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nBook Price <= 0");
                flag = true;
            }

        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input quantity: ");
                quantity = parseInt(sc.nextLine().trim());
                if (quantity < 0) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nQuantity erorr");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input publisherID: ");
                publisherID = sc.nextLine().trim();
                if (!findPubID(publisherID)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nPublisherId not found");
                flag = true;
            }
        } while (flag);

        booksList.add(new Books(bookID, bookName, bookPrice, quantity, publisherID));
        System.out.println("Create successfully");

    }

    public void ipBook(int pos) {

        String bookID = "";
        String bookName = "";
        double bookPrice = 0;
        int quantity = 0;
        String publisherID = "";
        String status = "";

        boolean flag = false;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Old book Id: " + booksList.get(pos).getBookID());
                System.out.println("Input new bookID: ");
                bookID = sc.nextLine().trim();
                if (!checkPatternBookId(bookID, "^B[0-9]{5}$") || checkDup(bookID, pos) >= 0) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nBook Id already exists or error");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Old book name: " + booksList.get(pos).getBookName());
                System.out.println("Input new bookname: ");
                bookName = sc.nextLine().trim();
                if (!checkLengthMinMax(bookName, 5, 30)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nBook Name is too long or too short");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Old bookPrice: " + booksList.get(pos).getBookPrice());
                System.out.println("Input new bookPrice: ");
                bookPrice = parseDouble(sc.nextLine().trim());
                if (bookPrice <= 0) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nBook Price <= 0");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Old quantity: " + booksList.get(pos).getQuantity());
                System.out.println("Input new quantity: ");
                quantity = parseInt(sc.nextLine().trim());
                if (quantity <= 0) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nQuantity erorr");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Old publisherID: " + booksList.get(pos).getPublisherID());
                System.out.println("Input new publisherID: ");
                publisherID = sc.nextLine().trim();
                if (!findPubID(publisherID)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nPublisherId not found");
                flag = true;
            }
        } while (flag);

        booksList.set(pos, new Books(bookID, bookName, bookPrice, quantity, publisherID));
        System.out.println("Update successfully");

    }

    public void findByBN() {
        System.out.println("Input a part of book name");
        boolean check = false;
        Scanner scc = new Scanner(System.in);
        String bN = scc.nextLine();

        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getBookName().indexOf(bN) >= 0) {
                System.out.println(booksList.get(i));
                check = true;
            }
        }
        if (!check) {
            System.out.println("Have no any Book");
        }

    }

    public void findByPI() {
        System.out.println("Input a part of Publisher");
        boolean check = false;
        Scanner scc = new Scanner(System.in);
        String pI = scc.nextLine();

        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getPublisherID().indexOf(pI) >= 0) {
                System.out.println(booksList.get(i));
                check = true;
            }
        }

        if (!check) {
            System.out.println("Have no any Book");
        }
    }

    public void searchBook() {
        System.out.println("\n-------------Create a Publisher------------");
        System.out.println("You want to find book by BookName or PublisherId");
        System.out.println("Input number 1 to find by Book Name");
        System.out.println("Input number 2 to find by PublisherId");
        System.out.print("Your choice: ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                findByBN();
                break;
            case 2:
                findByPI();
                break;
            default:
                break;
        }
    }

    public void updateBook() {
        System.out.println("\n------------- Update Book  ------------");
        System.out.println("Input bookID");
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        String bookID = sc.nextLine().trim();
        if (bookID.equals("")) {
            return;
        }
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getBookID().matches(bookID)) {
                System.out.println("Update " + booksList.get(i));
                ipBook(i);
                check = false;
            }
        }
        if (check) {
            System.out.println("Book ID does not exist\nUpdate fail");
        } else {
            System.out.println("Update success");
        }
    }

    public void deleteBook() {
        System.out.println("\n------------- Delete Book  ------------");
        System.out.println("Input bookID");
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        String bookID = sc.nextLine().trim();
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getBookID().matches(bookID)) {
                System.out.println("Do you want to delete " + booksList.get(i));
                System.out.println("Press Y/N to cormfim your choice");
                String choice = sc.nextLine().trim();
                if (choice.equalsIgnoreCase("Y")) {
                    booksList.remove(i);
                    check = false;
                }
            }
        }
        if (check) {
            System.out.println("Book ID does not exist\nDelete fail");
        } else {
            System.out.println("Delete success");
        }
    }

    public void saveBooksToFile() throws IOException {
        System.out.println("\n-------------Save the Books list to file------------");
        File f = new File(".\\src\\data\\Books.dat");
        FileWriter fw = new FileWriter(f); //
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i) != null) {
                String s = "";
                s += booksList.get(i) + "\n";
                pw.write(s);
            }
        }
        System.out.println("Save Data to File successfully ");
        fw.close();
        pw.close();
    }

    public void printALFF() {
        System.out.println("\n------------- Print all lists from file   ------------");
        inputBooksList();
        Collections.sort(booksList, new BooksComparator());

        for (int i = 0; i < booksList.size(); i++) {
            double subTotal = booksList.get(i).getBookPrice() * booksList.get(i).getQuantity();
            System.out.println(booksList.get(i).getBookID() + ", " + booksList.get(i).getBookName() + ", " + booksList.get(i).getBookPrice() + ", " + booksList.get(i).getQuantity() + ", " + subTotal + ", " + booksList.get(i).getStatus());
        }
    }
}
