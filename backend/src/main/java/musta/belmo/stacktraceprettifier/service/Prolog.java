package musta.belmo.stacktraceprettifier.service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Prolog {
	private String description;
	private Prolog prolog;
	
	public Prolog(String description) {
		this.description = description;
	}
	
	public static Prolog compactToNode(List<Prolog> prologs) {
		
		Prolog succ = null;
		Prolog n = null;
		for (int i = prologs.size() - 1; i >= 0; i--) {
			n = new Prolog(prologs.get(i).description);
			n.setProlog(succ);
			succ = n;
		}
		return n;
	}
}
