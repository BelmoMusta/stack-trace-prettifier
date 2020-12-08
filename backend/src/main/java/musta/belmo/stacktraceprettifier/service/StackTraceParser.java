package musta.belmo.stacktraceprettifier.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StackTraceParser {
	
	public static final String STACK_TRACE_LINE_REGEX = "^[\\t ]*at ((?:(?:[\\d\\w]*\\.)*[\\d\\w]*))\\." +
			"([\\d\\w\\$]*)" +
			"\\." +
			"([\\d\\w\\$]*)" +
			"\\((?:(?:([\\d\\w]*\\.java):(\\d*))|([\\d\\w\\s]*))\\)\\r?$";
	
	private static Pattern STACK_TRACE_LINE_PATTERN = Pattern.compile(STACK_TRACE_LINE_REGEX);
	
	
	public StackTrace executeParsing(String rawStackTrace) {
		String string = preformate(rawStackTrace);
		return parse(string);
	}
	
	private static String preformate(String string) {
		string = string.replaceAll("\\s+at\\s+", "\n\tat ");
		string = string.replaceAll("java.base/", "");
		return string.replaceAll("\\r", "\n");
	}
	
	public static StackTrace parse(String stackTraceString) {
		final List<StackTrace> stackTraces = new ArrayList<>();
		final String[] stacks = stackTraceString.split("Caused by");
		for (String causedBY : stacks) {
			String[] lines = causedBY.split("(\n\r)|\n");
			String firstLine = lines[0];
			List<Prolog> prologs = new ArrayList<>();
			String[] nested = lines[0].split("nested exception is");
			for (String nested_ : nested) {
				prologs.add(new Prolog(nested_));
			}
			
			
			final List<TraceElement> stackTraceLines = new ArrayList<>();
			for (int i = 1; i < lines.length; i++) {
				Matcher matcher = STACK_TRACE_LINE_PATTERN.matcher(lines[i]);
				
				if (matcher.matches()) {
					String packageName = matcher.group(1);
					String className = matcher.group(2);
					String methodName = matcher.group(3);
					
					String fileName = null;
					if (matcher.group(4) != null) {
						fileName = matcher.group(4);
					}
					
					String  lineNumber = "GENERATED";
					if (matcher.group(5) != null) {
						lineNumber = matcher.group(5);
					}
					
					if (matcher.group(6) != null && matcher.group(6).equals("Native Method")) {
						lineNumber = "NATIVE METHODE";
					}
					
					TraceElement element = new TraceElement(
							packageName,
							className,
							methodName,
							fileName,
							lineNumber
					);
					stackTraceLines.add(element);
				}
			}
			StackTrace e = new StackTrace(firstLine, stackTraceLines);
			e.setProlog(Prolog.compactToNode(prologs));
			stackTraces.add(e);
		}
		
		return compactToNode(stackTraces);
		
	}
	
	public static StackTrace compactToNode(List<StackTrace> a) {
		StackTrace succ = null;
		StackTrace n = null;
		for (int i = a.size() - 1; i >= 0; i--) {
			n = new StackTrace(a.get(i), succ);
			succ = n;
		}
		return n;
	}
}
