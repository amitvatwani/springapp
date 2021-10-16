package com.examly.springapp.dto;


public class GenericResponse<T> {
    private T response;

    public T getResponse() {
        return response; 
    }

    public void setResponse(T response) {
        this.response = response; 
    }

    @Override 
    public String toString() {
        return "GenericResponseDTO [response=" + response + "]"; 
    }
}
