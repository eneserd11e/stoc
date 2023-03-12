package com.enes.stock.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.enes.stock.dto.LogDto;
import com.enes.stock.dto.converter.LogDtoConverter;
import com.enes.stock.model.Log;
import com.enes.stock.repository.LogRepository;

@Service
public class LogService {

	private final LogRepository logRepository;
	private final LogDtoConverter logDtoConverter;
	
	
	public LogService(LogRepository logRepository, LogDtoConverter logDtoConverter) {
		super();
		this.logRepository = logRepository;
		this.logDtoConverter = logDtoConverter;
	}

	public Boolean addLog(LogDto log) {
		
		logRepository.save(new Log(log.getUserId()
				,log.getQuantity()
				,log.getStatus()
				,log.getExplanation()
				,LocalDateTime.now()));
		
		return true;
	}
	
	public List<LogDto> getLogList(){
		return logRepository.findAll()
				.stream()
				.map(log -> logDtoConverter.convert(log))
				.collect(Collectors.toList());
	}
	public Boolean deleteLogBetweenTwoDate(LocalDateTime date1,LocalDateTime date2) {
		return logRepository.deleteLogBetweenTwoDate(date1, date2);
	}
}
