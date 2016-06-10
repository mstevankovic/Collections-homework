package bigram_pekidz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Marko Stevankovic
 *
 */
public class Bigram 
{
	private static String string = "abbcceeeeeeabcc";
	private static Map<String, Integer> map = new HashMap<>();
	
	public static void printBigram(String string, Map map)
	{
		for (int i = 0; i < string.length() - 1; i++) 
		{
			String bigram = string.substring(i, i + 2);
			
			if (map.containsKey(bigram)) 
			{
				map.put(bigram, (int)map.get(bigram) + 1);
			}
			else 
			{
				map.put(bigram, 1);
			}
		}
		
		Iterator iterator = map.entrySet().iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
	public static void forseeNextThreeCharacters(String string, Map map, String forseeFor)
	{
		for (int i = 0; i < 3; i++)
		{
			int maxFrequency = 0;
			String maxFrequencyBigram = "";
			
			Iterator iterator = map.entrySet().iterator();
			
			while (iterator.hasNext())
			{
				Map.Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
				
				if (entry.getKey().startsWith(forseeFor.substring(forseeFor.length()-1)))
				{
					if (maxFrequency < entry.getValue())
					{
						maxFrequency = entry.getValue();
						maxFrequencyBigram = entry.getKey();
					}
				}
			}
			
			if (maxFrequency > 0)
			{
				char nextCharacter = maxFrequencyBigram.charAt(1);
				forseeFor = forseeFor + "" + nextCharacter;
			}
		}
		
		System.out.print("\nNext three characters(with starting characters): " + forseeFor + "\n");
		
	}
	
	public static void main(String[] args) 
	{		
			printBigram(string, map);
			
			String forseeFor = "ja";
			
			forseeNextThreeCharacters(string, map, forseeFor);
	}
}
