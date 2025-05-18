package com.vendor.vendormanagement.repository;

//import com.webapp.demo.Model.Wedding;
import com.vendor.vendormanagement.model.Wedding;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingRepository {

    List<Wedding> getAllWeddings();

    Wedding saveWedding(Wedding wedding);

    Wedding updateWedding(int clientId, Wedding wedding);

    boolean deleteWedding(int clientId);
}