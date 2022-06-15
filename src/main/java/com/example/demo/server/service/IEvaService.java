package com.example.demo.server.service;

import com.example.demo.dao.model.Eva;

import java.util.ArrayList;
import java.util.List;

public interface IEvaService {
    void insert(ArrayList<Eva> eva);


    List<Eva> search(Eva eva);

    int upeva(Eva eva);

    List<Eva> selectgood(Eva eva);
}
