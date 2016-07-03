package stam;


import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String args[]){
		
		
		System.out.println(solution(new int[]{1, 2, 1, -1}));

        
	}	
	
	public static int solution(int[] a) {
    	int len = a.length -1;
    	int stepsToGetOut = 0;
    	int loc = 0;
    	
    	while (loc >= 0){
    		//System.out.println(loc + " " + stepsToGetOut);
    		stepsToGetOut++;  (loc < len){
    	  		loc += a[loc];
    		}else if(loc > len || ((stepsToGetOut > len) && (loc == len))){
    			stepsToGetOut = -1;
    			break;
    		}else{
    			//stepsToGetOut++;
    			break;
    		}
    	}
    	//System.out.println(a[loc]);
    	/*if(a[len] < 0 && (a[len] == 0) || a[len] == -a[loc+a[loc]]){
    		stepsToGetOut = -1;
    	}else if(a[0] < 0){
    		stepsToGetOut = 1;
    	}*/
    	return stepsToGetOut;
	}
	
	public static String Tickets(int[] peopleInLine){
		String soldAll = "YES";
		int[] change = {0,0,0};
		
		for(int bill: peopleInLine){
			switch(bill)
			{
				case 25:
					change[0]++;
					break;
				case 50:
					if(change[0] >= 1){
						change[0]--;
						change[1]++;
					}else{
						soldAll = "NO";
					}
					break;
				case 100:
					if(change[0] >= 1 && change[1] >=1){
						change[0]--;
						change[1]--;
						change[2]++;
					}else if(change[0] >= 3){
						change[0] -= 3;
						change[2]++;
					}else{
						soldAll = "NO";
					}
					break;
			}
		}
		return soldAll;
	}
	
	
	  public static boolean groupCheck(String s){
		    String[] str = s.split("");
		    Map<Integer, String> open = new HashMap<Integer, String>();
		    HashMap<Integer, String> close = new HashMap<Integer, String>();
		    int even = 0;
		    boolean result = false;
		    
		    for(int i=0; i<str.length; i++){
		      if (str[i].equals("[") || str[i].equals("{") || str[i].equals("(")){
		        open.put(i, str[i]);
		        even++;
		      }else if(str[i].equals("]") || str[i].equals("}") || str[i].equals("}")){
		    	  close.put(i, str[i]);
		    	  even--;
		      }
		    }
		    
		    if(even == 0){
		    	for (Entry<Integer, String> entry : open.entrySet()) {

		    	}
		    }
		    return result;
		  }
	
	  
    public static boolean scramble(String str1, String str2) {
        String[] str2Arr = str2.split("");
        boolean a = true;
        
        for(String letter: str2Arr){
          if(str1.contains(letter) == false){
            return false;
          }
          str1 = str1.replaceFirst(letter, "");
        }
        return a;
      }
    
	
	public static String autocorrect(String input){
		String[] output = (input.toLowerCase()).split(" ");

		for(int i=0; i<output.length; i++){
			String a = output[i];
			if(a.equals("u")){
				output[i] = a.replace(a, "your sister");
			}
			else if(a.contains("youu")){
				output[i] = a.replace(a, "your sister");
			}else if(a.equals("you") || (a.contains("you") && Character.isLetter(a.charAt(3)) == false)){
				output[i] = a.replace("you", "your sister");
			}
		}
		String a = String.join(" ", output);
		return a;
	}
	
	
    public static String[] getCard()
    {
      Random rand = new Random();

      ArrayList<String> numbers = new ArrayList<>();
      String[] finalNums = new String[24];
      String[] bingo = {"B", "I", "N", "G", "O"};
      Integer randomNum;
	  int itemsNum;
	  
      
      for (int i=0; i<bingo.length; i++){
    	  int min = i*15+1;
    	  
    	  if (i != 2){
    		  itemsNum = 5;
    	  }else{
    		  itemsNum = 4;	  
    	  }
    	  for(int n=0; n<itemsNum; n++){
    		do{
    			randomNum = rand.nextInt(15) + min;
    		}
    		while(numbers.contains(bingo[i] + randomNum.toString()));
    		numbers.add(bingo[i] + randomNum.toString());
    	  }
      }
	
	  for(int n=0; n<finalNums.length; n++){
		  finalNums[n] = numbers.get(n);
	  }
      return finalNums;
    }
}
