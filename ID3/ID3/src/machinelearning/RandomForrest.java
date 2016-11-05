package machinelearning;

import java.util.*;

public class RandomForrest {
	int resultRandom[][] = new int[14895][200];
	ArrayList<Tree> genTrees = new ArrayList<Tree>();
	public int[] generateRandomAttr(){
		int attr[] = new int[10];
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<14; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0;i<10; i++) {
            attr[i] = list.get(i);
        }
        return attr;
	}
	public int[] populateMatrix(int matrix[][]){
		int values[] = new int[14895];
		for(int i=0;i<genTrees.size();i++)
		{
			for(int j=0;j<matrix.length;j++)
				resultRandom[j][i] = genTrees.get(i).traversalRandom(matrix[j]);
		}
		
		for(int i=0;i<14895;i++)
		{
			List asList = Arrays.asList(resultRandom[i]);
			Set<Integer> mySet = new HashSet<Integer>(asList);
			values[i] = (Collections.frequency(asList,1)>Collections.frequency(asList,0))?1:0;
		}
		findAccuracy(values,matrix);
		return values;
	}
	public void findAccuracy(int values[],int matrix[][]){
		double accuracy = 0.0;
  		int result[] = {0,0};
  		for(int i=0;i<values.length;i++){
  			if(values[i]==matrix[i][14])
  				result[1]++;
  			else
  				result[0]++;
  		}
  		accuracy = ((double)result[1]/(result[0]+result[1]))*100;
  		accuracy = Math.round(accuracy*100) / 100.0;
		System.out.println("Accuracy of the Random Forrest is : " + accuracy+"%");
  		System.out.println("It has correctly classified "+result[1]+" instances out of "+(result[0]+result[1])+" instances" );
	}
}
