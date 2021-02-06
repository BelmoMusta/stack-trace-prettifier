package musta.belmo.stacktraceprettifier.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@AllArgsConstructor
public class TraceElement {
	private String packageName;
	private String className;
	private String methodName;
	private String fileName;
	private String lineNumber;
	
	public boolean contains(String searchString) {
		if (StringUtils.isBlank(searchString)) return true;
		return StringUtils.contains(packageName, searchString) ||
				StringUtils.contains(className, searchString) ||
				StringUtils.contains(methodName, searchString) ||
				StringUtils.contains(fileName, searchString);
		
		
	}
	
	@Override
	public String toString() {
		return packageName + "." +
				className + "." +
				methodName + "." +
				lineNumber +'\n';
	}
}
