package me.klyucherov.cookbook1.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class FileService {
    private ObjectMapper objectMapper;

    public <T> void saveMapToFile(Map<Long, T> map, Path path){
        try {
            createNewFile(path);
            String json = objectMapper.writeValueAsString(map);
            Files.writeString(path, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> Map<Long, T> readMapFromFile(Path path, TypeReference<HashMap<Long, T>> typeReference) {
        try {
            String json = Files.readString(path);
            if (json.isEmpty()) {
                return new HashMap<>();
            }
            return objectMapper.readValue(json, typeReference);
        } catch (NoSuchFileException e) {
            return new HashMap<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createNewFile(Path path) throws IOException {
        Files.deleteIfExists(path);
        Files.createFile(path);
    }


}
