/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leaapfrog.FileImporter.impl;

import com.leaapfrog.FileImporter.dao.FileDAO;
import com.leaapfrog.FileImporter.entity.Advertise;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author welcome
 */
public class FileDAOimpl implements FileDAO {
    
    List<Advertise> list=new ArrayList();

    @Override
    public List<Advertise> getall() {
    return list;    }

    @Override
    public void insert(Advertise a) {
     list.add(a);
    }

    @Override
    public Advertise getbyid(int id) {
    for(Advertise a:list){
        if(a.getId()==id)
            return a;
    }
    return null;}
    
}
