package machinelearning;
import java.util.*;

public class TreeBuilder {
	
	public Map<String,int[]> findRoot(DataCount tempData,List<String> attributes){
		HashMap<String, Double> hm = new HashMap<String, Double>();
		if(attributes.contains("age"))
			hm.put("age",printMap(tempData.age));
		if(attributes.contains("workClass"))
			hm.put("workClass",printMap(tempData.workClass));
		if(attributes.contains("fnlwgt"))
			hm.put("fnlwgt",printMap(tempData.fnlwgt));
		if(attributes.contains("education"))
			hm.put("education",printMap(tempData.education));
		if(attributes.contains("educationNum"))
			hm.put("educationNum",printMap(tempData.educationNum));
		if(attributes.contains("maritalStatus"))
			hm.put("maritalStatus",printMap(tempData.maritalStatus));
		if(attributes.contains("occupation"))
			hm.put("occupation",printMap(tempData.occupation));
		if(attributes.contains("relationship"))
			hm.put("relationship",printMap(tempData.relationship));
		if(attributes.contains("race"))
			hm.put("race",printMap(tempData.race));
		if(attributes.contains("sex"))
			hm.put("sex",printMap(tempData.sex));
		if(attributes.contains("capitalGain"))
			hm.put("capitalGain",printMap(tempData.capitalGain));
		if(attributes.contains("capitalLoss"))
			hm.put("capitalLoss",printMap(tempData.capitalLoss));
		if(attributes.contains("hoursPerWeek"))
			hm.put("hoursPerWeek",printMap(tempData.hoursPerWeek));
		if(attributes.contains("nativeCountry"))
			hm.put("nativeCountry",printMap(tempData.nativeCountry));
		int i = 0;
		for (Map.Entry<String, Double> entry : hm.entrySet()) {
			i++;
		    System.out.println(i+" "+entry.getKey()+" : "+entry.getValue());
		}
		printValues(tempData.age);
		return tempData.age;
	}
	/**
	 * @param mp : A Map which has an attribute as its key and an array showing the spread of positives and negatives as its value
	 * @return The entropy of the passed Map.
	 */
	public double printMap(Map<String,int[]> mp) {
		double entropy = 0.0;
		double indiEntropy[] =  new double[mp.size()];
		int sum_value=0;
		int i = 0;
		for (Map.Entry<String, int[]> entry : mp.entrySet()) {
		    int[] value = entry.getValue();
		    double temp1 = (double)value[0]/(value[0]+value[1]);
		    double temp2 = (double)value[1]/(value[0]+value[1]);
		    indiEntropy[i] = -temp1*(Math.log(temp1)/Math.log(2))-temp2*(Math.log(temp2)/Math.log(2));
		    if(Double.isNaN(indiEntropy[i]))
		    	indiEntropy[i] = 0.0;
		    entropy = (value[0]+value[1])*indiEntropy[i];
		    sum_value += value[0]+value[1];
		    i++;
		}
		
		entropy = entropy/sum_value;
		//System.out.println(entropy);
		return entropy;
	}
	public void printValues(Map<String,int[]> mp){
		int global=0;
		for (Map.Entry<String, int[]> entry : mp.entrySet()) {
		    int[] value = entry.getValue();
		    System.out.println(value[0]+" "+value[1]);
		    global += value[0]+value[1];
		}
		System.out.println("*****");
		System.out.println(global);
		System.out.println("*****");
	}
}
