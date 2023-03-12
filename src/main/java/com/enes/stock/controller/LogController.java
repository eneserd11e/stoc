package com.enes.stock.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.enes.stock.dto.LogDto;
import com.enes.stock.service.LogService;

@RestController
@RequestMapping("v1/log/")
public class LogController {

	private LogService logService;

	public LogController(LogService logService) {
		super();
		this.logService = logService;
	}
	
	public ResponseEntity<Boolean> addLog(@RequestBody LogDto log){
		return ResponseEntity.ok(logService.addLog(log));
		
	}
	
	public ResponseEntity<List<LogDto>> getAllLog(){
		return ResponseEntity.ok(logService.getLogList());
	}
	
	public ResponseEntity<Boolean> deleteLogBetweenTwoDate(@RequestBody LocalDateTime date1,LocalDateTime date2){
		return ResponseEntity.ok(logService.deleteLogBetweenTwoDate(date1, date2));
	}
}
