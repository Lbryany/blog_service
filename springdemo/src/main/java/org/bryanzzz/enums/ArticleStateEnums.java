package org.bryanzzz.enums;

public enum ArticleStateEnums {

    SUCCESS(1,"操作成功");

    private int State;

    private String StateInfo;

    ArticleStateEnums(int state, String stateInfo) {
        State = state;
        StateInfo = stateInfo;
    }

    public int getState() {
        return State;
    }

    public String getStateInfo() {
        return StateInfo;
    }

    public static ArticleStateEnums stateOf(int index){
        for(ArticleStateEnums state: values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }


}
