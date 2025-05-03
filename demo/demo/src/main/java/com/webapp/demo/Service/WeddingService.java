package com.webapp.demo.Service;

import com.webapp.demo.Model.Wedding;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WeddingService {

    List<Wedding> getAllWedding();

    Optional<Wedding> saveWedding(Wedding wedding);

    Optional<Wedding> updateWedding(int clientId, Wedding wedding);

    boolean deleteWedding(int clientId);
}
