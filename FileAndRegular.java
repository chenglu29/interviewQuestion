
import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.*;
import java.util.*;

class FileAndRegular{
	public static void main(String[] args){
	     try {
	     	Map<String,Integer> map=new HashMap<String, Integer>();
     		 File myObj = new File("a.txt");
      		Scanner myReader = new Scanner(myObj);
      		 FileWriter myWriter = new FileWriter("req_a.txt");
      		while (myReader.hasNextLine()) {
        		String data = myReader.nextLine();
  //      		Pattern pattern = Pattern.compile("\\d{2}/.../\\d\\{4}:\\d{2}:\\d{2}:\\d{2}");
        		Pattern pattern = Pattern.compile("\\d{2}/[a-zA-Z]{3}/\\d{4}:\\d{2}:\\d{2}:\\d{2}");
    			Matcher matcher = pattern.matcher(data);

      			if (matcher.find( )) {
      				String ss=matcher.group(0);
         			//System.out.println("Found value: " + ss );
         			map.put(ss,!map.containsKey(ss)?1:(map.get(ss)+1));
      //   			System.out.println("this map "+map);
      //   			myWriter.write(matcher.group(0)+"\r\n");
      			} else {
         			System.out.println("NO MATCH");
      			}
        		//System.out.println(data);
      			}

      			Iterator<Map.Entry<String, Integer>> entries=map.entrySet().iterator();
      			while (entries.hasNext()) {
 				   Map.Entry<String, Integer> entry = entries.next();
 				   if(entry.getValue().equals(1)){
 				   	  entries.remove();
 				   	System.out.println("find 1!!!!");
 				   }
 			 //      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
 		//	       myWriter.write( entry.getKey()+ entry.getValue()+"\r\n");
 				}

 				Iterator iter = map.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry entry = (Map.Entry) iter.next();
					Object key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + ":" + value);
					myWriter.write( key+"\r\n");
				}

      //			myWriter.write(map);
      		myReader.close();      
      		myWriter.close();
    		} catch (FileNotFoundException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    		}
    		catch (IOException e) {
     			 System.out.println("An error occurred.");
     			 e.printStackTrace();
    		}
    }
}


    