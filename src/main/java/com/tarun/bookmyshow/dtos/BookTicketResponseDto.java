package com.tarun.bookmyshow.dtos;

import com.tarun.bookmyshow.models.Ticket;
import lombok.Data;

@Data
public class BookTicketResponseDto {

    private ResponseDto responseDto;
    private Ticket ticket;

    public static BookTicketResponseDto getTicketSuccessMessage(String message, Ticket ticket) {

        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        bookTicketResponseDto.setResponseDto(ResponseDto.getSuccessMessage(message));
        bookTicketResponseDto.setTicket(ticket);
        return bookTicketResponseDto;
    }

    public static BookTicketResponseDto getTicketFailureMessage(String message, Ticket ticket) {

        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        bookTicketResponseDto.setResponseDto(ResponseDto.getFailureMessage(message));
        bookTicketResponseDto.setTicket(ticket);
        return bookTicketResponseDto;
    }
}
