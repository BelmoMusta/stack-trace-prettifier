package musta.belmo.stacktraceprettifier.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class StackTrace {
	@JsonIgnore
	private String firstLine;
	private Prolog prolog;
	private List<TraceElement> stackTraceLines;
	private StackTrace causedBy;
	
	public StackTrace(String firstLine, List<TraceElement> stackTraceLines) {
		this.firstLine = firstLine;
		this.stackTraceLines = stackTraceLines;
	}
	
	public StackTrace(StackTrace stackTrace, StackTrace causedBy) {
		this(stackTrace.firstLine, stackTrace.stackTraceLines);
		this.prolog = stackTrace.prolog;
		this.causedBy = causedBy;
	}
	
	public List<TraceElement> getLinesOfPackage(String packageName) {
		List<TraceElement> linesOfPackage = new ArrayList<>();
		
		for (TraceElement line : this.stackTraceLines) {
			if (line.toString().startsWith(packageName)) {
				linesOfPackage.add(line);
			}
		}
		
		return linesOfPackage;
	}
	
	@Override
	public String toString() {
		try {
			return toJson();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String toHtml() {
		StringBuilder stringBuilder = new StringBuilder();
		if (causedBy != null) {
			stringBuilder.append("Cause By ");
			stringBuilder.append(causedBy.toHtml());
		}
		return "<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min" +
				".css\">\n" +
				"\n" +
				"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n" +
				"\t<title></title>\n" +
				"</head>\n" +
				"<body>" +
				firstLine + // compact
				"<table class=\"table table-striped\">" +
				"<tr>\n" +
				"    <th>Class Name</th>\n" +
				"    <th>File Name</th>\n" +
				"    <th>Method Name</th>\n" +
				"    <th>Line number</th>\n" +
				"  </tr>"
				+ toTrTdTable()
				+ "</table>" +
				stringBuilder
				+ "</body>\n" +
				"</html>";
	}
	
	public String toTrTdTable() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (TraceElement stackTraceElement : stackTraceLines) {
			stringBuilder.append("<tr>\n");
			
			stringBuilder.append("<td>\n");
			stringBuilder.append(stackTraceElement.getClassName());
			stringBuilder.append("</td>\n");
			
			stringBuilder.append("<td>\n");
			stringBuilder.append(Optional.ofNullable(stackTraceElement.getFileName()).orElse(""));
			stringBuilder.append("</td>\n");
			
			stringBuilder.append("<td>\n");
			stringBuilder.append(stackTraceElement.getMethodName());
			stringBuilder.append("</td>\n");
			
			stringBuilder.append("<td>\n");
			stringBuilder.append(Optional.of(stackTraceElement.getLineNumber())
					.map(String::valueOf)
					.orElse(""));
			stringBuilder.append("</td>\n");
			
			
			stringBuilder.append("</tr>\n");
		}
		return stringBuilder.toString();
	}
	
	String toJson() throws IOException {
		StringWriter stringWriter = new StringWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(stringWriter, this);
		return stringWriter.toString();
	}
	
}