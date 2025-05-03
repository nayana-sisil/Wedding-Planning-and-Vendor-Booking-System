package com.webapp.demo.Repositorary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.webapp.demo.Model.Wedding;
import com.webapp.demo.Model.IndoorWedding;
import com.webapp.demo.Model.OutdoorWedding;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WeddingRepositoryImpl implements WeddingRepository {

    private static final String FILE_PATH = "weddings.txt";

    @Override
    public List<Wedding> getAllWeddings() {
        File file = new File("weddings.txt");
        ObjectMapper objectMapper = configureObjectMapper();
        List<Wedding> weddings = new ArrayList<>();

        try {
            if (file.exists() && file.length() > 0) {
                weddings = objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Wedding.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weddings;
    }

    @Override
    public Wedding saveWedding(Wedding wedding) {
        List<Wedding> weddings = getAllWeddings();
        weddings.add(wedding);

        ObjectMapper objectMapper = configureObjectMapper();
        try {
            objectMapper.writeValue(new File("weddings.txt"), weddings);
            return wedding;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Wedding updateWedding(int clientId, Wedding wedding) {
        List<Wedding> weddings = getAllWeddings();
        for (int i = 0; i < weddings.size(); i++) {
            Wedding existing = weddings.get(i);
            if (existing.getClientId() == clientId) {
                weddings.set(i, wedding);
                ObjectMapper objectMapper = configureObjectMapper();
                try {
                    objectMapper.writeValue(new File("weddings.txt"), weddings);
                    return wedding;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteWedding(int clientId) {
        List<Wedding> weddings = getAllWeddings();
        Wedding toRemove = null;

        for (Wedding w : weddings) {
            if (w.getClientId() == clientId) {
                toRemove = w;
                break;
            }
        }

        if (toRemove != null) {
            weddings.remove(toRemove);
            ObjectMapper objectMapper = configureObjectMapper();
            try {
                objectMapper.writeValue(new File("weddings.txt"), weddings);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private ObjectMapper configureObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }
}