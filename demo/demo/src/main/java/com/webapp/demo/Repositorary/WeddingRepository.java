package com.webapp.demo.Repositorary;

import com.webapp.demo.Model.Wedding;
import java.util.List;

public interface WeddingRepository {

    List<Wedding> getAllWeddings();

    Wedding saveWedding(Wedding wedding);

    Wedding updateWedding(int clientId, Wedding wedding);

    boolean deleteWedding(int clientId);
}