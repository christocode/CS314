import java.util.Hashtable;

@SuppressWarnings("serial")
public class Metadata extends Hashtable<String, String> {
	public Metadata() {
		super();
	}
	
	public Metadata(String[][] coll) {
		for (String[] pair : coll)
			this.put(pair[0], pair[1]);
	}
	
	public String put(String k, String v) {
		return super.put(k.toLowerCase(), v);
	}
	
	public String get(String k) {
		String result = super.get(k.toLowerCase());
		
		if (result == null)
			return "";
		else 
			return result;
	}
}
