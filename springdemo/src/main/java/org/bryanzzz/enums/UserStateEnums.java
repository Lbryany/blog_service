package org.bryanzzz.enums;

public enum UserStateEnums {

    SUCCESS(1,"登录成功"),
    FAIL(-1, "登录失败");


    private int State;

    private String StateInfo;

    UserStateEnums(int state, String stateInfo) {
        State = state;
        StateInfo = stateInfo;
    }

    public int getState() {
        return State;
    }

    public String getStateInfo() {
        return StateInfo;
    }

    public static UserStateEnums stateOf(int index){
        for(UserStateEnums state: values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }



}
