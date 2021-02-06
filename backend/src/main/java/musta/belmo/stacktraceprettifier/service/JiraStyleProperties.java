package musta.belmo.stacktraceprettifier.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
@Setter
public class JiraStyleProperties {
	
	@Value("${style.package}")
	private String stylePackage;
	@Value("${style.className}")
	private String styleClassName;
	@Value("${style.fileName}")
	private String styleFileName;
	@Value("${style.methodName}")
	private String styleMethodName;
	@Value("${style.lineNumber}")
	private String styleLineNumber;
	@Value("${style.description}")
	private String styleDescription;
	@Value("${style.panel}")
	private String stylePanel;
	
	static JiraStyleProperties config;
	
	@PostConstruct
	public void init() {
		config = this;
	}
	
	public static JiraStyleProperties get() {
		return config;
	}
	
}
