package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sun.util.locale.StringTokenIterator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Test {
	public static void main(String[] args) throws MalformedURLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//charFreq("india is great country");
		//wordCount("sachin sachin arun arun chotu");
		System.out.println(args);
	}
	
	
	//String given = "india is great country";
	
	
	public static void charFreq(String given){
		char a[] = given.toCharArray();
		
		Set noRed = new HashSet();
		for(int i=0;i<a.length;i++){
			noRed.add(a[i]);
		}
		
		LinkedList fin = new LinkedList();
		Iterator itr = noRed.iterator(); 
		while(itr.hasNext()){
			fin.add(itr.next());
			}

		for(int i=0;i<fin.size();i++){
			int counter = 0;
			System.out.print(fin.get(i));
			for(int j=0;j<a.length;j++){
				if(fin.get(i).equals(given.charAt(j))){
					counter++;
				}
			}
			System.out.println("=="+counter);
			
		}
			
			
			
		
	}
		
	public static void wordCount(String given){
		Set noRedSet = new HashSet();
		List redList = new LinkedList();
		List noRedList = new LinkedList();
		
		
		
		StringTokenizer st = new StringTokenizer(given, " ");
		while(st.hasMoreTokens()){
			String currentToken = st.nextToken();
			noRedSet.add(currentToken);
			redList.add(currentToken);
		}

		Iterator itr =noRedSet.iterator();
		while(itr.hasNext()){
			noRedList.add(itr.next());
		}
		
		for(int i = 0;i<noRedList.size();i++){
			int counter = 0;
			System.out.print(noRedList.get(i));
			for(int j=0;j<redList.size();j++){
				if(noRedList.get(i).equals(redList.get(j))){
					counter++;
				}
				
			}
			
			System.out.println("=="+counter);
		}
		
		
	}

	public static int strToInt(String given){
		int number = 0;
		int k = 1;
		for(int i=1;i<=given.length()-1;i++){
			k=k*10;
		}

		for(int j=0;j<=given.length()-1;j++){
			number = number+((given.charAt(j)-48)*k);
			k=k/10;
		}
		return number;
	}
	
}
	
	
	
	
	
