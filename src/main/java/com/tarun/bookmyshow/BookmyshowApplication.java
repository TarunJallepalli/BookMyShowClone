package com.tarun.bookmyshow;

import com.tarun.bookmyshow.controller.TicketController;
import com.tarun.bookmyshow.dtos.BookTicketRequestDto;
import com.tarun.bookmyshow.dtos.BookTicketResponseDto;
import com.tarun.bookmyshow.models.*;
import com.tarun.bookmyshow.repository.CityRepo;
import com.tarun.bookmyshow.repository.ShowRepo;
import com.tarun.bookmyshow.repository.ShowSeatRepo;
import com.tarun.bookmyshow.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class BookmyshowApplication implements CommandLineRunner {

	@Autowired
	TicketController ticketController;

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BookTicketRequestDto requestDto = new BookTicketRequestDto();
		requestDto.setShowSeatIds(List.of(1));
		requestDto.setUserId(1);
		BookTicketResponseDto responseDto = ticketController.bookTicket(requestDto);
		log.info(responseDto.getTicket().toString());
	}
}
