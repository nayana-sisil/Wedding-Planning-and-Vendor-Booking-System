package com.vendor.vendormanagement.service;


import com.vendor.vendormanagement.model.Wedding;
import com.vendor.vendormanagement.repository.WeddingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeddingServiceImplement implements WeddingService {

    //


    final WeddingRepository weddingRepository;

    public WeddingServiceImplement(WeddingRepository weddingRepository) {
        this.weddingRepository = weddingRepository;
    }

    //



    @Override
    public List<Wedding> getAllWedding() {
        return weddingRepository.getAllWeddings();
    }

    @Override
    public Optional<Wedding> saveWedding(Wedding wedding) {
        Wedding saveWedding = weddingRepository.saveWedding(wedding);

        if (saveWedding != null) {
            return Optional.of(saveWedding);
        }
        else {
            return Optional.empty();
        }
    }

    //


    @Override
    public Optional<Wedding> updateWedding(int clientId, Wedding wedding) {
        Wedding updateWedding = weddingRepository.updateWedding( clientId, wedding);

        if (updateWedding != null) {
            return Optional.of(updateWedding);
        }
        else {
            return Optional.empty();
        }
    }

    //


    @Override
    public boolean deleteWedding(int clientId) {
        return weddingRepository.deleteWedding(clientId);
    }

    @Override
    public Optional<Wedding> findWeddingById(int id) {
        return weddingRepository.getAllWeddings().stream()
                .filter(w -> w.getClientId() == id)
                .findFirst();


    }
}
