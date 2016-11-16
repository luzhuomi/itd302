package itd302.practical6;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.Description;

@Description(name = "removelink", 
	value = "_FUNC_(text) - remove the links of pattern 'http://...' from the text.")

public class UDFRemoveLink extends UDF
{

	private Pattern pattern;

	public UDFRemoveLink() 
	{
		this.pattern = Pattern.compile("http(?:s?)://[a-zA-Z0-9\\./\\-\\+@]+");
	};

	public String evaluate(String text) 
	{
		Matcher m = this.pattern.matcher(text);
		return m.replaceAll("");
	}

}
