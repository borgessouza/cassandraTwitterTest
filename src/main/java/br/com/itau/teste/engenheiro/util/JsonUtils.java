package br.com.itau.teste.engenheiro.util;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonUtils {

    private Gson gson = new Gson();

    public Map fromJsonToMap(final String json) {
        return gson.fromJson(json, Map.class);
    }
    //TODO metodo para transformar em String apartir de Map
}
