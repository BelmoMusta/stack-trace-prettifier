package musta.belmo.stacktraceprettifier.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
			"([\\d\\w\\$<>]*)" +
			"\\((?:(?:([\\d\\w]*\\.java):(\\d*))|([\\d\\w\\s]*))\\)\\r?$";
	public static final String STR = "{panel:title=Stack|borderColor=#ccc|titleBGColor=#F7D6C1|bgColor=#011627}";
	
	private static Pattern STACK_TRACE_LINE_PATTERN = Pattern.compile(STACK_TRACE_LINE_REGEX);
	
	public StackTrace executeParsing(String rawStackTrace) {
		return executeParsing(StringUtils.defaultString(rawStackTrace), "");
	}
	
	public StackTrace executeParsing(String rawStackTrace, String filter) {
		String string = preformate(rawStackTrace);
		return parse(string, filter);
	}
	
	public StackTrace executeParsing(TraceDTO traceDTO) {
		return executeParsing(StringUtils.defaultString(traceDTO.getRawStackTrace()), traceDTO.getFilter());
	}
	
	private static String preformate(String string) {
		string = string.replaceAll("\\s+at\\s+", "\n\tat ");
		string = string.replaceAll("java.base/", "");
		return string.replaceAll("\\r", "\n");
	}
	
	public static StackTrace parse(String stackTraceString, String filter) {
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
					
					String lineNumber = "GENERATED";
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
					if (element.contains(filter)) {
						stackTraceLines.add(element);
					}
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
	
	public String toJiraCommentString(String traceDTO, String filter) {
		TraceDTO traceDTO1 = new TraceDTO();
		traceDTO1.setRawStackTrace(traceDTO);
		traceDTO1.setFilter(filter);
		return toJiraCommentString(traceDTO1);
	}
	
	public String toJiraCommentString(TraceDTO traceDTO) {
		StringBuilder builder = new StringBuilder(STR);
		StackTrace stackTrace = executeParsing(traceDTO);
		int y = 0;
		while (stackTrace != null) {
			put(builder, stackTrace, y > 0);
			stackTrace = stackTrace.getCausedBy();
			y++;
		}
		builder.append("{panel}");
		return builder.toString();
	}
	
	private void put(StringBuilder builder, StackTrace stackTrace, boolean isCauseByClause) {
		if (isCauseByClause) {
			builder.append("{color:red} *CAUSED BY :*{color} \n");
		}
		Prolog prolog = stackTrace.getProlog();
		while (prolog != null) {
			applyJiraCommentStyle(prolog);
			builder.append(prolog.getDescription());
			prolog = prolog.getProlog();
		}
		stackTrace.getStackTraceLines().stream().peek(this::applyJiraCommentStyle)
				.forEach(builder::append);
	}

	@Autowired
	JiraStyleProperties jiraStyleProperties;
	
	@SuppressWarnings("all")
	private void applyJiraCommentStyle(TraceElement lineO) {
		
		lineO.setPackageName(String.format(jiraStyleProperties.getStylePackage(), lineO.getPackageName()));
		lineO.setClassName(String.format(jiraStyleProperties.getStyleClassName(), lineO.getClassName()));
		lineO.setFileName(String.format(jiraStyleProperties.getStyleFileName(), lineO.getFileName()));
		lineO.setMethodName(String.format(jiraStyleProperties.getStyleMethodName(), lineO.getMethodName()));
		lineO.setLineNumber(String.format(jiraStyleProperties.getStyleLineNumber(), lineO.getLineNumber()));
		
	}
	
	private void applyJiraCommentStyle(Prolog prolog) {
		prolog.setDescription("{color:#f78c6c}" + prolog.getDescription() + "{color}\n");
		
	}
}
