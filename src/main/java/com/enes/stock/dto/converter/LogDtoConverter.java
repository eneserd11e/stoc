package com.enes.stock.dto.converter;

import org.springframework.stereotype.Component;

import com.enes.stock.dto.LogDto;
import com.enes.stock.model.Log;

@Component
public class LogDtoConverter {

	public LogDto convert(Log from) {
		return new LogDto(from.getId()
				,from.getUserId()
				,from.getAmount()
				,from.getStatus()
				,from.getExplanation()
				,from.getDateTime());
	}
}
