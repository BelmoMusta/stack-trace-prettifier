package musta.belmo.stacktraceprettifier.rest;

import musta.belmo.stacktraceprettifier.service.StackTrace;
import musta.belmo.stacktraceprettifier.service.StackTraceParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class Controller {
	@Autowired
	private StackTraceParser stackTraceParser;
	@GetMapping
	public String ok() {
		return "Stack Trace Prettifier V1.0";
	}
	
	@PostMapping("/prettify")
	public StackTrace prettify(@RequestBody String rawStackTrace) {
		return stackTraceParser.executeParsing(rawStackTrace);
	}
}
