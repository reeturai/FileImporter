/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leaapfrog.FileImporter.grabber;

import com.leaapfrog.FileImporter.dao.FileDAO;
import com.leaapfrog.FileImporter.entity.Advertise;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author welcome
 */
public class Grabber {

    private FileDAO dao;
    private String filename;

    public static boolean isNumeric(String data) {
        try {
            int number = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public Grabber(FileDAO dao, String filename) {
        this.dao = dao;
        this.filename = filename;

    }

    public void mistakes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder broken = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    int id = Integer.parseInt(tokens[0]);
                    Advertise ad = new Advertise();
                    if (dao.getbyid(id) == null) {
                        ad.setId(id);
                        ad.setTitle(tokens[1]);
                        if (isNumeric(tokens[2]) && isNumeric(tokens[3])) {
                            ad.setDisount(Integer.parseInt(tokens[2]));
                            ad.setDay(Integer.parseInt(tokens[3]));
                            dao.insert(ad);
                        } else {
                            broken.append(line).append("\r\n");
                        }

                    } else {
                        broken.append(line).append("\r\n");
                    }

                } else {
                    broken.append(line).append("\r\n");
                }
            }
            reader.close();
            System.out.println(broken.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
