//Java Imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Abhishek Vishwanath Deshpande on 6/17/2017.
 */
public class DressCode {

    //HashMap which stores commands and their respective String components
    private HashMap<Integer,ArrayList<String>> commandMap;

    //HashMap which stores index of command and their current state as value
    private HashMap<Integer,Integer> stateMap = new HashMap<>();

    //Atomic value of State at any given moment (HOT/COLD)
    private Integer state = 0;

    //Set inital values for HashMap
    public void setCommandMap(){
        commandMap =  new HashMap<>();

        commandMap.put(1,new ArrayList<>(Arrays.asList("sandals","boots")));
        commandMap.put(2,new ArrayList<>(Arrays.asList("sun visor","hat")));
        commandMap.put(3,new ArrayList<>(Arrays.asList("fail","socks")));
        commandMap.put(4,new ArrayList<>(Arrays.asList("t shirt","shirt")));
        commandMap.put(5,new ArrayList<>(Arrays.asList("fail","jacket")));
        commandMap.put(6,new ArrayList<>(Arrays.asList("shorts","pants")));
        commandMap.put(7,new ArrayList<>(Arrays.asList("leaving house","leaving house")));
        commandMap.put(8,new ArrayList<>(Arrays.asList("removing PJs","removing PJs")));

    }

    //Set initial values for State Map
    public void setStateMap(){

        stateMap.put(1,0);
        stateMap.put(2,0);
        stateMap.put(3,0);
        stateMap.put(4,0);
        stateMap.put(5,0);
        stateMap.put(6,0);
        stateMap.put(7,0);
        stateMap.put(8,0);


    }

    //Setter for State
    public void setState(int state){
        this.state = state;
    }

    //Getter for state
    public int getState(){
        return this.state;
    }

    //Getter for command String values for associated index
    public ArrayList<String> getFromCommandMap(int index){
        return commandMap.get(index);
    }

    //Methods for executing given command with handling of associated constraints given in problem statement.

    public String putOnFootwear(){
        if(stateMap.get(1)==1)
            return "fail";

        if(stateMap.get(6)!=1)
            return "fail";

        if(state==1){
            if(stateMap.get(3)!=1)
                return "fail";
        }

        stateMap.put(1,1);

        return commandMap.get(1).get(state);

    }

    public String putOnHeadwear(){
        if(stateMap.get(2)==1)
            return "fail";

        if(stateMap.get(4)!=1)
            return "fail";

        stateMap.put(2,1);

        return commandMap.get(2).get(state);
    }

    public String putOnSocks(){
        if(state==0)
            return "fail";
        if(stateMap.get(3)==1)
            return "fail";

        stateMap.put(3,1);

        return commandMap.get(3).get(state);
    }

    public String putOnShirt(){
        if(stateMap.get(4)==1)
            return "fail";

        stateMap.put(4,1);

        return commandMap.get(4).get(state);
    }

    public String putOnJacket(){
        if(state==0)
            return "fail";
        if(stateMap.get(4)!=1)
            return "fail";
        if(stateMap.get(5)==1)
            return "fail";

        stateMap.put(5,1);

        return commandMap.get(5).get(state);
    }

    public String putOnPants(){
        if(stateMap.get(6)==1)
            return "fail";

        stateMap.put(6,1);

        return commandMap.get(6).get(state);

    }

    public String leaveHouse(){
        if(state==0){
            if(stateMap.get(1)!=1 || stateMap.get(2)!=1 || stateMap.get(4)!=1 || stateMap.get(6)!=1 )
                return "fail";
        }
        if(state==1){
            for(int i=1;i<=6;i++)
                if(stateMap.get(i)!=1)
                    return "fail";
        }

        stateMap.put(7,1);

        return commandMap.get(7).get(state);
    }
}
