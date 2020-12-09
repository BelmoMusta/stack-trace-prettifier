package musta.belmo.stacktraceprettifier.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Getter
@Setter
public class Config {
	@Value("#{'${non.important.packages:}'.split(';')}")
	private List<String> nonImportantPackages;
	
	static Config config;
	@PostConstruct
	public void init(){
		config = this;
	}
	
	public static Config get() {
		return config;
	}
}
