/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leaapfrog.FileImporter;

import com.leaapfrog.FileImporter.dao.FileDAO;
import com.leaapfrog.FileImporter.grabber.Grabber;
import com.leaapfrog.FileImporter.impl.FileDAOimpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

  

    public static void main(String[] args) {
        FileDAO dao = new FileDAOimpl();
        System.out.println("Enter the filename to write");
        Scanner input = new Scanner(System.in);
        String filename = "";
        filename = input.next();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter((filename)));

            writer.write("1" + "," + "python" + "," + "10" + "," + "10"+"\r\n");
            writer.write("2" + "," + "core java" + "," + "20" + "," + "20"+"\r\n");
            writer.write("3" + "," + "python" + ","+"\r\n");
            writer.write("1" + "," + "python" + "," + "20" + "," + "10"+"\r\n");
            writer.write("5" + "," + "advanced java" + "," + "hel" + "," + "10");
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        while (true) {
            System.out.println("enter the file you want to import");
            filename = input.next();
            File file = new File(filename);
            if (file.exists() && file.isFile()) {
                break;
            } else {
                System.out.println("invalid file");
            }
        }
       Grabber grabber=new Grabber(dao,filename);
           grabber.mistakes();
                   
    }
}
