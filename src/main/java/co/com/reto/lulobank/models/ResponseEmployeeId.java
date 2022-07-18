package co.com.reto.lulobank.models;

import lombok.Data;

@Data
public class ResponseEmployeeId{
    private DataJson data;
    private String status;
    private String message;
}
