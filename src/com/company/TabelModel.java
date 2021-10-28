package com.company;

public class TabelModel {
    private int primaryKey,att1,att2,att3,att4;
    public TabelModel(int primaryKey, int att1, int att2, int att3, int att4) {
        this.primaryKey = primaryKey;
        this.att1 = att1;
        this.att2 = att2;
        this.att3 = att3;
        this.att4 = att4;
    }

    public int getAttribute(int index){
        switch (index){
            case 0:
                return getPrimaryKey();
            case 1:
                return getAtt1();
            case 2:
                return getAtt2();
            case 3:
                return getAtt3();
            case 4:
                return getAtt4();
            default:
                return -1;
        }
    }

    public void setAttribute(int index, int val){
        switch (index){
            case 0:
                 setPrimaryKey(val);
                 break;
            case 1:
                setAtt1(val);
                break;
            case 2:
                setAtt2(val);
                break;
            case 3:
                setAtt3(val);
                break;
            case 4:
                setAtt4(val);
                break;
        }
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int getAtt1() {
        return att1;
    }

    public void setAtt1(int att1) {
        this.att1 = att1;
    }

    public int getAtt2() {
        return att2;
    }

    public void setAtt2(int att2) {
        this.att2 = att2;
    }

    public int getAtt3() {
        return att3;
    }

    public void setAtt3(int att3) {
        this.att3 = att3;
    }

    public int getAtt4() {
        return att4;
    }

    public void setAtt4(int att4) {
        this.att4 = att4;
    }

    @Override
    public String toString() {
        return "{" + primaryKey +
                ", " + att1 +
                ", " + att2 +
                ", " + att3 +
                ", " + att4 +
                '}'+"\n";
    }
}
