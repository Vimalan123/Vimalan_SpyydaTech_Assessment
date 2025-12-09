import java.util.*;
public class wordfrequency 
{
   public static void main(String[] args)
 {   
    String text = "Hello world, hello Spyyda";
    Map<String, Integer> wordCount = new HashMap<>();
    text = text.toLowerCase();

    text = text.replace(",","");
    text = text.replace(".","");
    
    String[] words = text.split(" ");
    for(String word : words)
    {
        if(! wordCount.containsKey(word))
        {
            wordCount.put(word, 1);
        }
        else
        {
            wordCount.put(word, wordCount.get(word) + 1);
        }
    }

    List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
    {
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)
        {
            return e2.getValue() - e1.getValue();
        }
    });

    for(Map.Entry<String, Integer> entry : list)
    {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}