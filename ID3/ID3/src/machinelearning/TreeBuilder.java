package machinelearning;
import java.util.*;

public class TreeBuilder {
	/**
	 * @param tempData : The dataset
	 * @param attributes : The list attributes which we should consider while making a node of the tree
	 * @return the label of the attribute which has the lowest entropy for the given dataset and attributes
	 */
	public String findRoot(DataCount tempData,List<String> attributes){
		HashMap<String, Double> hm = new HashMap<String, Double>();
		if(attributes.contains("age"))
			hm.put("age",calcEntropy(tempData.age));
		if(attributes.contains("workClass"))
			hm.put("workClass",calcEntropy(tempData.workClass));
		if(attributes.contains("fnlwgt"))
			hm.put("fnlwgt",calcEntropy(tempData.fnlwgt));
		if(attributes.contains("education"))
			hm.put("education",calcEntropy(tempData.education));
		if(attributes.contains("educationNum"))
			hm.put("educationNum",calcEntropy(tempData.educationNum));
		if(attributes.contains("maritalStatus"))
			hm.put("maritalStatus",calcEntropy(tempData.maritalStatus));
		if(attributes.contains("occupation"))
			hm.put("occupation",calcEntropy(tempData.occupation));
		if(attributes.contains("relationship"))
			hm.put("relationship",calcEntropy(tempData.relationship));
		if(attributes.contains("race"))
			hm.put("race",calcEntropy(tempData.race));
		if(attributes.contains("sex"))
			hm.put("sex",calcEntropy(tempData.sex));
		if(attributes.contains("capitalGain"))
			hm.put("capitalGain",calcEntropy(tempData.capitalGain));
		if(attributes.contains("capitalLoss"))
			hm.put("capitalLoss",calcEntropy(tempData.capitalLoss));
		if(attributes.contains("hoursPerWeek"))
			hm.put("hoursPerWeek",calcEntropy(tempData.hoursPerWeek));
		if(attributes.contains("nativeCountry"))
			hm.put("nativeCountry",calcEntropy(tempData.nativeCountry));
		double min = 5.0;
		String label = "";
		for (Map.Entry<String, Double> entry : hm.entrySet()) {
		    if(entry.getValue()<min && entry.getValue()!=0.0)
		    {
		    	min = entry.getValue();
		    	label = entry.getKey();
		    }
		}
		return label;
	}
	/**
	 * @param mp : A Map which has an attribute as its key and an array showing the spread of positives and negatives as its value
	 * @return The entropy of the passed Map.
	 */
	public double calcEntropy(Map<String,int[]> mp) {
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
		return entropy;
	}
	public void printValues(Map<String,int[]> mp){
		int global=0;
		for (Map.Entry<String, int[]> entry : mp.entrySet()) {
		    int[] value = entry.getValue();
		    global += value[0]+value[1];
		}
		System.out.println(global);
	}
}
