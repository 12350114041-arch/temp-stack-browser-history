package com.github.affandes.kuliah.pm;

import java.io.*;
import java.util.*;

public class FileSplitterWithQueue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();

        System.out.print("Masukkan nama file (contoh: input.txt): ");
        String filename = input.nextLine();

        System.out.print("Masukkan jumlah baris per potongan: ");
        int linesPerChunk = input.nextInt();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            int count = 0;
            int part = 1;

            while ((line = reader.readLine()) != null) {
                queue.add(line); 

                if (++count == linesPerChunk) {
                    printChunk(queue, part++);
                    queue.clear();
                    count = 0;
                }
            }

            if (!queue.isEmpty()) { 
                printChunk(queue, part);
            }

        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }

    private static void printChunk(Queue<String> q, int part) {
        System.out.println("\n=== Bagian #" + part + " ===");
        for (String s : q) {
            System.out.println(s);
        }
    }
}
