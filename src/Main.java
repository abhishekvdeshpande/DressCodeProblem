/**
 * Created by Abhishek Vishwanath Deshpande on 6/17/2017.
 */

//Java Imports
import java.util.*;

public class Main {

    //Method to check for valid comma separated input between 1 and 8
    public static int checkForValidInput(String inputList) {
    	try{
    		for (String h : inputList.split(",")) {
                int currentInput = Integer.parseInt(h);
                if (currentInput < 1 || currentInput > 8) {
                    return 0;
                }


            }
    	}
    	catch(NumberFormatException numberFormatException){
    		System.out.println("Please enter valid Numbers");
    		return 0;
    	}
        
        return 1;
    }



    public static void main(String args[]){

        //Declare Object for DressCode.
        DressCode dressCode = new DressCode();

        //Set Intial values for command map and state map.
        dressCode.setCommandMap();
        dressCode.setStateMap();



        //Counter
        int i=0;

        String[] results = new String[10];

        Scanner kbd = new Scanner(System.in);

        int state=-1;

        System.out.println("Enter State: 0 for HOT, 1 FOR COLD");

        state = kbd.nextInt();

        while(state!=0 && state!=1){
            System.out.println("Invalid Input, Enter State: 0 for HOT, 1 FOR COLD");
            state = kbd.nextInt();
        }


        //Set State
        dressCode.setState(state);

        System.out.println("Enter comma separated value of inputs between 1 and 8");

        String inputList = kbd.next();

        int successfulInput = checkForValidInput(inputList);


        while(successfulInput!=1){
            System.out.println("Invalid Input, Enter comma separated value of inputs between 1 and 8");

            inputList = kbd.next();

            successfulInput = checkForValidInput(inputList);

        }

        int length = inputList.split(",").length;

        int[] input = new int[10];

        for(int k=0;k<length;k++){
            input[k] = Integer.parseInt(inputList.split(",")[k]);
        }

        //If initial command is not remove pyjamamas, stop executiton and
        if(input[0]!=8){
            System.out.println("fail");
        }


        else{
            //Set initial command to remove pyjamas
            results[0] = dressCode.getFromCommandMap(8).get(state);

            //Loop over other commands in the input and call appropriate methods
            for(i =1;i<length;i++){
                if(results[i-1]=="fail")
                    break;
                else{
                    switch (input[i]){
                        case 1: results[i]=dressCode.putOnFootwear();
                                break;
                        case 2: results[i]=dressCode.putOnHeadwear();
                            break;
                        case 3: results[i]=dressCode.putOnSocks();
                            break;
                        case 4: results[i]=dressCode.putOnShirt();
                            break;
                        case 5: results[i]=dressCode.putOnJacket();
                            break;
                        case 6: results[i]=dressCode.putOnPants();
                            break;
                        case 7: results[i]=dressCode.leaveHouse();
                            break;
                        case 8: results[i]="fail";
                            break;


                    }
                }

            }
            //Print output commands
            System.out.print(results[0]);
            for(int j=1;j<i;j++)
                System.out.print(","+results[j]);
        }


    }



}
