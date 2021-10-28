package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int nextRan = 1;
    private static final int KEY = 5209;
    private static final int ATTRIBUTE_SIZE = 5;
    private static final int BIT_SIZE = 31;
    public static void main(String[] args) {
        TabelModel model1 = new TabelModel(1,1,2,3,4);
        TabelModel model2 = new TabelModel(2,3,1,3,4);
        TabelModel model3 = new TabelModel(3,6,5,3,4);
        TabelModel model4 = new TabelModel(4,2,4,3,4);
        TabelModel model5 = new TabelModel(5,7,8,3,4);
        TabelModel model6 = new TabelModel(6,4,3,3,4);
        TabelModel model7 = new TabelModel(7,8,7,3,4);
        TabelModel model8 = new TabelModel(8,5,9,3,4);
        TabelModel model9 = new TabelModel(9,9,6,3,4);
        List<TabelModel> tabels = new ArrayList<>();
        Collections.addAll(tabels,
                model1,
                model2,
                model3,
                model4,
                model5,
                model6,
                model7,
                model8,
                model9
        );

        System.out.println("Before marking");
        System.out.println(tabels);

        for (int i = 0; i<tabels.size(); i++) {
            TabelModel tabelModel = tabels.get(i);
            int seed = tabelModel.getPrimaryKey()+KEY;
            if(randomGen(seed)%3==0){
                int attributeIndex = randomGen(seed)%(ATTRIBUTE_SIZE-1);
                int bitIndex = randomGen(seed)%(BIT_SIZE);
                tabels.set(i,mark(tabelModel,randomGen(seed),attributeIndex,bitIndex));
            }
        }
        System.out.println("After Marking");
        System.out.println(tabels);
        int totalCount = 0;
        int matchCount = 0;
        nextRan = 1;
        for (int i = 0; i<tabels.size(); i++) {
            TabelModel tabelModel = tabels.get(i);
            int seed = tabelModel.getPrimaryKey()+KEY;
            if(randomGen(seed)%3==0){
                int attributeIndex = randomGen(seed)%(ATTRIBUTE_SIZE-1);
                int bitIndex = randomGen(seed)%(BIT_SIZE);
                totalCount++;
                matchCount += verifyMark(tabelModel,randomGen(seed),attributeIndex,bitIndex);
            }
        }

        System.out.println("Total Count= "+totalCount+" Match Count= "+matchCount);
    }

    static TabelModel mark(TabelModel tabelModel,int randomNumber, int attributeIndex, int bitIndex){
        int val = tabelModel.getAttribute(attributeIndex+1);
        if(randomNumber%2==0){
            val = val & ~(1<<bitIndex);
        }else{
            val = (1<<bitIndex)|val;
        }
        tabelModel.setAttribute(attributeIndex+1,val);

        return tabelModel;
    }

    static int randomGen(int seed){
        int prime = 23197;
        int a = 6091;
        return (seed*a+nextRan++)%prime;
    }

    static int verifyMark(TabelModel tabelModel,int randomNumber, int attributeIndex, int bitIndex){
        int val = tabelModel.getAttribute(attributeIndex+1);
        if(randomNumber%2==0){
            return ((val & ((1<<bitIndex))) ==0?1:0);
        }else{
            return  ((1<<bitIndex)&val)>=1?1:0;
        }
    }
}
