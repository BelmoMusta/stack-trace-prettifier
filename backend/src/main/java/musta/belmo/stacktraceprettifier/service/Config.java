package musta.belmo.stacktraceprettifier.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		System.out.println(creerBlocsBENLSelonTailleTexte("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
				"Sed pulvinar dolor odio, non auctor ipsum malesuada nec. Ut tristique sapien non tristique laoreet. " +
				"Vivamus tellus tellus, condimentum sed eleifend in, dignissim eu ex. Morbi aliquet eleifend faucibus." +
				" Proin blandit erat fermentum, semper massa quis, vestibulum arcu. Donec convallis elementum porta. " +
				"Sed sollicitudin sapien in nunc convallis, nec rhoncus mi vulputate.\n" +
				"\n" +
				"Morbi feugiat arcu et mattis imperdiet. Etiam efficitur lorem eu tempus lacinia. Vivamus et risus " +
				"placerat, bibendum neque ut, suscipit odio. Nulla rhoncus pharetra fringilla. Nullam non ullamcorper " +
				"nibh. Ut facilisis diam massa, in pellentesque nibh suscipit nec. Nam eu posuere turpis. Pellentesque" +
				" consectetur dui dui, quis posuere erat vehicula et.\n" +
				"\n" +
				"In hac habitasse platea dictumst. Ut pellentesque sem diam, molestie molestie risus rhoncus vitae. " +
				"Sed lobortis sit amet odio et fermentum. Quisque et accumsan dui. Etiam eget scelerisque purus, sit " +
				"amet commodo diam. Curabitur consequat arcu vel arcu condimentum porttitor. Proin aliquet finibus mi " +
				"nec tempus. In ac sapien ut sapien rhoncus auctor at vitae lacus. Etiam porttitor erat arcu.\n" +
				"\n" +
				"Nunc eget lacus tempor tellus auctor tristique eget in tortor. Mauris congue vel libero eget porta. " +
				"Sed ullamcorper erat quis felis sagittis tempus. Vestibulum ante ipsum primis in faucibus orci luctus" +
				" et ultrices posuere cubilia curae; Aenean efficitur aliquet vehicula. Praesent nec orci ac turpis " +
				"fermentum ultricies. Suspendisse feugiat ante sem, vitae ornare sapien lacinia et.\n" +
				"\n" +
				"Nullam dui risus, interdum sit amet lacinia at, facilisis vel augue. Etiam ac velit ac sem facilisis " +
				"tincidunt. Aenean tempus, ex in finibus tincidunt, nunc orci bibendum metus, a elementum massa leo ac" +
				" turpis. Ut placerat ex sed odio congue aliquet. Duis ac sem ut elit laoreet suscipit. Morbi a dui at" +
				" libero pretium varius id eu purus. Cras ac velit sed lectus fermentum tristique non a lacus. Etiam " +
				"eleifend arcu elit, sed efficitur tellus pulvinar sed. Nulla facilisi. Nullam ac pulvinar risus, vel " +
				"aliquam nisi. Fusce elementum pellentesque dui, ac feugiat eros tincidunt tincidunt.\n" +
				"\n" +
				"Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas " +
				"blandit pharetra quam, ac bibendum lectus. Fusce eget dictum mi. In eget felis erat. Etiam pretium " +
				"felis ut velit consequat commodo. Praesent volutpat erat diam, nec porta magna luctus eu. Duis " +
				"euismod porttitor maximus. Proin tortor orci, aliquet quis tincidunt vitae, cursus ac sapien. Cras eu" +
				" massa quam. Etiam ipsum diam, vestibulum tincidunt lacus quis, ullamcorper consequat massa. Etiam " +
				"cursus neque neque, eu rhoncus massa dignissim at. Morbi justo tortor, iaculis eu orci in, iaculis " +
				"imperdiet nulla. Vivamus egestas, odio eget efficitur fringilla, dui purus tempor ex, quis molestie " +
				"mauris massa eget ipsum. Nam et diam convallis, ornare augue quis, volutpat est. Sed eget ultricies " +
				"mi.\n" +
				"\n" +
				"Suspendisse fringilla quis mauris nec placerat. Sed vehicula lobortis lacus at ultricies. Suspendisse" +
				" non efficitur libero. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam interdum metus " +
				"non nibh lacinia euismod. Sed condimentum dolor nec ex mattis mattis. Sed accumsan, justo quis " +
				"vestibulum pharetra, dui dui tincidunt lacus, et tempor ex urna nec magna. Vestibulum lacinia risus " +
				"sit amet neque placerat, sed maximus lectus bibendum.\n" +
				"\n" +
				"Mauris sodales porta hendrerit. Quisque aliquet bibendum ex ut aliquet. Suspendisse potenti. Donec " +
				"commodo laoreet purus, ut hendrerit lectus finibus ut. In a neque vel odio maximus interdum a sit " +
				"amet est. Ut semper rhoncus aliquet. Donec a urna eget est pulvinar suscipit nec vel ligula. Sed " +
				"vitae lobortis ante. Mauris malesuada auctor lacus, id molestie nulla aliquam sed. Nullam dolor " +
				"massa, efficitur id lorem non, vulputate viverra ipsum. Morbi consectetur faucibus pharetra. Mauris " +
				"sit amet arcu consequat, maximus leo quis, semper arcu.\n" +
				"\n" +
				"Aliquam nec libero non risus egestas condimentum. Suspendisse eu lacus tincidunt, fermentum sem " +
				"vitae, egestas nibh. Proin sed elementum enim, ut tincidunt velit. Cras mattis augue nec orci egestas" +
				" ornare. Donec pharetra volutpat nulla, eu elementum ligula facilisis in. Pellentesque at nunc mollis" +
				" risus tincidunt ullamcorper. Pellentesque interdum dictum lorem, eu sollicitudin ipsum commodo vel. " +
				"Aenean eleifend est velit, quis pretium ex ultricies vitae. In pharetra nulla quam.\n" +
				"\n" +
				"Integer feugiat risus sed ligula aliquet, ut gravida nibh pellentesque. Praesent turpis quam, " +
				"consectetur sed posuere in, lobortis quis turpis. Duis quis dui eget odio mattis hendrerit. Aliquam " +
				"elementum, neque ullamcorper cursus hendrerit, turpis arcu tincidunt magna, at pulvinar mauris erat " +
				"et purus. Nulla lobortis sollicitudin luctus. Mauris nec urna velit. Sed ut porttitor quam. Donec " +
				"suscipit nec leo at pellentesque. Praesent feugiat mattis orci eu sollicitudin.\n" +
				"\n" +
				"Nam urna nibh, facilisis ac fermentum ultricies, vestibulum commodo lacus. Proin quis massa nisi. " +
				"Nunc pulvinar finibus diam, in ultrices ex commodo non. Aliquam fermentum, tortor eu blandit egestas," +
				" ex arcu facilisis tellus, id vehicula ligula lectus dignissim ligula. Pellentesque ultricies mollis " +
				"metus non ullamcorper. Curabitur vestibulum dui et sodales sagittis. Nulla interdum arcu mi, " +
				"venenatis suscipit ante congue sit amet. Donec nec tellus eget risus vestibulum sollicitudin vitae " +
				"convallis magna.\n" +
				"\n" +
				"Phasellus id arcu ut tortor pulvinar varius vel nec nibh. Sed maximus semper tristique. Nam interdum " +
				"vestibulum eros ac tempus. Fusce in dui urna. Vestibulum et justo nec leo volutpat scelerisque. " +
				"Phasellus eget dolor dolor. Maecenas justo metus, ornare ac malesuada vel, commodo quis magna. " +
				"Vivamus non porttitor est. Morbi mi mauris, pretium rhoncus maximus ac, tincidunt non justo. Morbi " +
				"sed nulla rutrum, accumsan magna non, semper est.\n" +
				"\n" +
				"Cras tellus dui, congue et tortor vehicula, tincidunt mattis mi. Sed bibendum lorem a condimentum " +
				"tincidunt. Nam augue orci, rhoncus quis condimentum sed, laoreet ut ex. Vivamus vel dolor porta diam " +
				"auctor sodales. Donec convallis lectus sed nibh malesuada sodales. Vivamus eu tortor lacus. Mauris " +
				"dapibus, nisi ac maximus iaculis, orci sem dictum massa, vel tincidunt velit nunc vel libero. Nam ac " +
				"erat magna. Mauris dapibus nunc eu pharetra rutrum. In at lectus mauris. Donec sit amet orci et quam " +
				"lobortis facilisis. Donec congue faucibus urna, nec convallis sem consequat non. Integer consectetur," +
				" risus nec elementum tempus, arcu lorem dignissim justo, et fermentum justo metus sit amet mi. Donec " +
				"leo turpis, tempor eu condimentum sed, bibendum vitae lacus. Cras laoreet magna a eros cursus " +
				"condimentum nec faucibus sem. Mauris finibus nisl et dui ornare sagittis. Curabitur viverra"));
	}
	
	
	private static String creerBlocsBENLSelonTailleTexte(String text)  {
		List<String> listeDesParties = new ArrayList<>();
		String clauseBeneficiaireLibre = text;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < clauseBeneficiaireLibre.length(); i++) {
			char caractere = clauseBeneficiaireLibre.charAt(i);
			if(caractere == '\n'){
				caractere = 'µ';
			}
			stringBuilder.append(caractere);
			if (i != 0 && i % 800 == 0) {
				listeDesParties.add(stringBuilder.toString());
				stringBuilder = new StringBuilder();
			}
		}
		StringBuilder lignesBENL = new StringBuilder();
		for (String partie : listeDesParties) {
			lignesBENL.append(partie).append('\n');
		}
		return lignesBENL.toString();
	}
}
