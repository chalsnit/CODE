/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author nghia
 */
class PublisherComparator implements Comparator<Publishers> {

    @Override
    public int compare(Publishers s1, Publishers s2) {
        return s1.getPublisherName().compareTo(s2.getPublisherName());
    }
}

public class PublishersMa extends Publishers {

    Vector<Publishers> publisherList = new Vector();

    public boolean checkPatternPublisherId(String st, String pattern) {
        return st.matches(pattern);
    }

    public boolean checkLengthMinMax(String st, int min, int max) {
        return !(st.length() < min || st.length() > max);
    }

    public int checkDup(String st) {
        for (int i = 0; i < publisherList.size(); i++) {
            if (publisherList.get(i).getPublisherId().equals(st)) {
                return i;
            }

        }

        return -1;
    }

    public void inputPublisherList() {
        publisherList.clear();
        boolean flag = false;
        do {
            try {
                FileReader fileInput = new FileReader(".\\src\\data\\Publisher.dat");
                BufferedReader br = new BufferedReader(fileInput);

                String line = br.readLine();
                while (line != null) {
                    StringTokenizer st = new StringTokenizer(line, ",", false);
                    while (st.hasMoreElements()) {
                        String publisherId = st.nextToken().trim();
                        if (!checkPatternPublisherId(publisherId, "^P[0-9]{5}$") || checkDup(publisherId) >= 0) {
                            System.out.println("\nPublisher Id already exists or error");
                            throw new Exception();
                        }

                        String publisherName = st.nextToken().trim();
                        if (!checkLengthMinMax(publisherName, 5, 30)) {
                            System.out.println("\nPublisher Name is too long or too short");
                            throw new Exception();
                        }

                        String phone = st.nextToken().trim();
                        if (!checkLengthMinMax(phone, 10, 12)) {
                            System.out.println("\nPhone Number is too long or too short");
                            throw new Exception();
                        }

                        publisherList.add(new Publishers(publisherId, publisherName, phone));

                        flag = false;
                        line = br.readLine();

                    }
                }

                br.close();
                fileInput.close();
            } catch (Exception e) {
                System.out.println("Please, Check Publishers.dat and press ENTER to continue");
                Scanner sc = new Scanner(System.in);
                String tmp = sc.nextLine();
                flag = true;

            }

        } while (flag);

    }

    public void createAPublisher() {
        System.out.println("\n-------------Create a Publisher------------");
        boolean flag = false;
        String publisherId = "";
        String phone = "";
        String publisherName = "";

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input PublisherId: ");
                publisherId = sc.nextLine().trim();
                if (!checkPatternPublisherId(publisherId, "^P[0-9]{5}$") || checkDup(publisherId) >= 0) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nPublisher Id already exists or error");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input publisherName: ");
                publisherName = sc.nextLine().trim();
                if (!checkLengthMinMax(publisherName, 5, 30)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nPublisher Name is too long or too short");
                flag = true;
            }
        } while (flag);

        flag = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input Phone: ");
                phone = sc.nextLine().trim();
                if (!checkLengthMinMax(phone, 10, 12)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nPhone Number is too long or too short");
                flag = true;
            }
        } while (flag);

        publisherList.add(new Publishers(publisherId, publisherName, phone));
        System.out.println("Create a Publisher success");

    }

    public void deleteThePublisher() {
        System.out.println("\n-------------Delete the Publisher------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input PublisherId which you wanna delete");
        String publisherId = sc.nextLine();
        int pos = checkDup(publisherId);
        if (pos == -1) {
            System.out.println("PublisherId does not exist\nDelete PublisherId fail");
        } else {
            publisherList.remove(pos);
            System.out.println("Delete PublisherId success");
        }
    }

    public void savePublisherToFile() throws IOException {
        System.out.println("\n-------------Save the Books list to file------------");
        File f = new File(".\\src\\data\\Publisher.dat");
        FileWriter fw = new FileWriter(f); //
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < publisherList.size(); i++) {
            if (publisherList.get(i) != null) {
                String s = "";
                s += publisherList.get(i) + "\n";
                pw.write(s);
            }
        }
        System.out.println("Save Data to File successfully ");
        fw.close();
        pw.close();
    }

    public void printPublisherList() {
        System.out.println("\n-------------Print the Publisher list from the file------------");
        inputPublisherList();

        Collections.sort(publisherList, new PublisherComparator());
        for (int i = 0; i < publisherList.size(); i++) {
            System.out.println(publisherList.get(i));
        }
        System.out.println("Print the Publisher list from the file success");

    }

//    public static void main(String[] args) {
//        // TODO code application logic here
//        PublishersMa pub = new PublishersMa();
//        
//        pub.inputPublisherList();
//       pub.printPublisherList();
//       pub.createAPublisher();
//       pub.printPublisherList();
//        
//    }
}
