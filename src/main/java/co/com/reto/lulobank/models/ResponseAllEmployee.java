package co.com.reto.lulobank.models;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllEmployee {
    private String status;
    private String message;
    private List<DataJson> data;
}
