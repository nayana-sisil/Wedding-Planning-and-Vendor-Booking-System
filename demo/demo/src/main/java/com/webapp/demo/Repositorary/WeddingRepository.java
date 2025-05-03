package com.webapp.demo.Repositorary;

import com.webapp.demo.Model.Wedding;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingRepository {

    List<Wedding> getAllWeddings();

    Wedding saveWedding(Wedding wedding);

    Wedding updateWedding(int clientId, Wedding wedding);

    boolean deleteWedding(int clientId);
}