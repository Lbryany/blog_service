package org.bryanzzz.enums;

public enum ExceptionStateEnums {


    RUNEXCEPTION(-10001, "登录失败");


    private int State;

    private String StateInfo;

    ExceptionStateEnums(int state, String stateInfo) {
        State = state;
        StateInfo = stateInfo;
    }

    public int getState() {
        return State;
    }

    public String getStateInfo() {
        return StateInfo;
    }

    public static ExceptionStateEnums stateOf(int index){
        for(ExceptionStateEnums state: values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }

}
