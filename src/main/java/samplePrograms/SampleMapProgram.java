package samplePrograms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SampleMapProgram {
	
	public static void main(String args[])
	{
		Map<String,String> myMap=new HashMap<String,String>();
		myMap.put("1", "Sopendra");
		myMap.put("2", "Ashu");
		myMap.put("3", "Pradeep");
		myMap.put("4", "Puja");
		
		Set<Map.Entry<String, String>> mazaMap = myMap.entrySet();
		for(Entry<String, String> myEntry:mazaMap)
		{
			System.out.println(myEntry.getKey());
			System.out.println(myEntry.getValue());
		}
		
		
		Iterator<Entry<String, String>> myIterator=mazaMap.iterator();
		while(myIterator.hasNext())
		{
			System.out.println(myIterator.next());
		}
		
		mazaMap.forEach((c)->System.out.println(c));
	}

}
