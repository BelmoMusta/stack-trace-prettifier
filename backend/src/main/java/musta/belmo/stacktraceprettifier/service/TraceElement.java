package musta.belmo.stacktraceprettifier.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@AllArgsConstructor
public class TraceElement {
	
	private final String packageName;
	private final String className;
	private final String methodName;
	private final String fileName;
	private final String lineNumber;
	
	public boolean contains(String searchString) {
		if (StringUtils.isBlank(searchString)) return true;
		return StringUtils.contains(packageName, searchString) ||
				StringUtils.contains(className, searchString) ||
				StringUtils.contains(methodName, searchString) ||
				StringUtils.contains(fileName, searchString);
		
		
	}
	
}
