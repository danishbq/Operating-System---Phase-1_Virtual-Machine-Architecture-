//Operating Systems (6683) - Phase 1
//Group Members:
//   Ahmed Raza - 22787
//   Asad Virani - 22787
//   Danish Badar Qureshi - 22890

package osphase1;

public class Flag extends Register{
    Register flag;
    void setcarry(){
        ori(flag,1);
    }
    void setzero(){
        ori(flag,2);
        
    }void setsign(){
        ori(flag,4);
        
    }void setoverflow(){
        ori(flag,8);
        
    }
    boolean getcarry(){
        if(andi(flag,1)==1)
            return true;
        return false;
    }
    boolean getzero(){
        if(andi(flag,2)==1)
            return true;
        return false;
    }
    boolean getsign(){
        if(andi(flag,4)==1)
            return true;
        return false;
    }
    boolean getoverflow(){
        if(andi(flag,8)==1)
            return true;
        return false;
    }
    
    void ori(Register r1, int num){
        r1.setValue((short) (r1.getValue()|num));
    }
    int andi(Register r1, int num){
        r1.setValue((short) (r1.getValue()&num));
        return r1.getValue();
        
    }
}
