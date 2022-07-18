package co.com.reto.lulobank.models;
import lombok.Data;

@Data
public class ResponseEmployeeCreate {
    private DataResponseCreate data;
    private String status;
    private String message;
}
