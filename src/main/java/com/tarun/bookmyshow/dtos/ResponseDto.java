package com.tarun.bookmyshow.dtos;

import lombok.Data;

@Data
public class ResponseDto {

    private ResponseStatus responseStatus;
    private String message;

    public static ResponseDto getSuccessMessage(String message) {

        ResponseDto responseDto = new ResponseDto();
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setMessage(message);
        return responseDto;
    }

    public static ResponseDto getFailureMessage(String message) {

        ResponseDto responseDto = new ResponseDto();
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        responseDto.setMessage(message);
        return responseDto;
    }

}
