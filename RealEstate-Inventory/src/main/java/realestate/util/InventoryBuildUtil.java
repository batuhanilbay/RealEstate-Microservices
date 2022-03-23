package realestate.util;

public class InventoryBuildUtil {

	private static String template = "<p>Hos geldin ${product},</p>\n" ;
	
	private InventoryBuildUtil() {
		
	} 
		
	public static String build(String productName) {
		return template.replaceAll("\\$\\{*product\\}", productName.split("@")[0]);
	}
	
}
