import java.io.*;
import java.util.*;
/**
 * @author Sandeep,Snehal,Kushagra,Tanmay
 * AIM : To implement and find the efficieny of ID3 algorithm on a particular Dataset.
 */

/**
 * DataSet is an object which captures the information of one row in the Data.
 */
class DataSet{
	int age;
	String workClass;
	int fnlwgt;
	String education;
	int educationNum;
	String maritalStatus;
	String occupation;
	String relationship;
	String race;
	String sex;
	int capitalGain;
	int capitalLoss;
	int hoursPerWeek;
	String nativeCountry;
	int result;
	DataSet(int age,String workClass,int fnlwgt,String education,int educationNum,String maritalStatus,String occupation,String relationship,String race,String sex,int capitalGain,int capitalLoss,int hoursPerWeek,String nativeCountry,String income){
		this.age =  age;
		this.workClass = workClass;
		this.fnlwgt = fnlwgt;
		this.education = education;
		this.educationNum = educationNum;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.relationship = relationship;
		this.race = race;
		this.sex = sex;
		this.capitalGain = capitalGain;
		this.capitalLoss = capitalLoss;
		this.hoursPerWeek = hoursPerWeek;
		this.nativeCountry = nativeCountry;
		result = income.equals("<=50k")?0:1;
	}
	
}
public class ID3 {
	public static ArrayList<DataSet> data = new ArrayList<DataSet>();
  	public static void main(String[] args) {
        try{
        	inputHandle();
        }catch(Exception e){
        	System.out.println(e);
        }
  	}
  	/**
  	 * @throws IOException
  	 * Reads the data from the text file and stores it in the object.
  	 */
  	public static void inputHandle()throws IOException {
  		 BufferedReader br = new BufferedReader(new FileReader("adult.txt"));
         String line=null;
         int i = 0;
         while( (line=br.readLine()) != null) {
        	 int flag = 1;
        	i++;
			StringTokenizer st = new StringTokenizer(line,", ");
			int age=0;
			String workClass=null;
			int fnlwgt=0;
			String education=null;
			int educationNum=0;
			String maritalStatus=null;
			String occupation=null;
			String relationship = null;
			String race=null;
			String sex=null;
			int capitalGain=0;
			int capitalLoss=0;
			int hoursPerWeek=0;
			String nativeCountry=null;
			String income = null;
             while(st.hasMoreTokens()){
            	 age = Integer.parseInt(st.nextToken());
            	 workClass = st.nextToken();
            	 if(workClass.equals("?"))
            		 flag = 0;
            	 fnlwgt = Integer.parseInt(st.nextToken());
            	 education = st.nextToken();
            	 educationNum = Integer.parseInt(st.nextToken());
            	 maritalStatus = st.nextToken();
            	 occupation = st.nextToken();
            	 if(occupation.equals("?"))
            		 flag = 0;
            	 relationship = st.nextToken();
            	 race = st.nextToken();
            	 sex = st.nextToken();
            	 capitalGain = Integer.parseInt(st.nextToken());
            	 capitalLoss = Integer.parseInt(st.nextToken());
            	 hoursPerWeek = Integer.parseInt(st.nextToken());
            	 nativeCountry = st.nextToken();
            	 if(nativeCountry.equals("?"))
            		 flag = 0;
            	 income = st.nextToken();
             }
             if(flag==1)
            	 data.add(new DataSet(age,workClass,fnlwgt,education,educationNum,maritalStatus,occupation,relationship,race,sex,capitalGain,capitalLoss,hoursPerWeek,nativeCountry,income));
         }
         System.out.println(i);
         br.close();
  	}
}