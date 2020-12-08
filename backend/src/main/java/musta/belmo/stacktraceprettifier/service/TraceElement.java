package musta.belmo.stacktraceprettifier.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TraceElement {
	
	private final String packageName;
	private final String className;
	private final String methodName;
	private final String fileName;
	private final String lineNumber;
	
}
