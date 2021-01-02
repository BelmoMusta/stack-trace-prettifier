package musta.belmo.stacktraceprettifier.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
	
	public List<TraceElement> excludeLinesOfPackages(List<String> packageName) {
		Predicate<TraceElement> predicate =   traceElement -> true;
		
		for (String pkgName : packageName) {
			predicate = predicate.and(traceElement -> !traceElement.getPackageName().contains(pkgName));
		}
		return stackTraceLines.stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}
	
	
	public List<TraceElement> getImportantLines() {
		List<String> nonImportantPackages = Config.get().getNonImportantPackages();
		return excludeLinesOfPackages(nonImportantPackages);
	}
	
}