package musta.belmo.stacktraceprettifier.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TraceDTO {
	private String rawStackTrace;
	private String filter;
}
