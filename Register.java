//Operating Systems (6683) - Phase 1
//Group Members:
//   Ahmed Raza - 22787
//   Asad Virani - 22787
//   Danish Badar Qureshi - 22890

package osphase1;

abstract class Register {
    short value;
    
    void setValue(short n){
        value=n;
    }
    short incValue(){
        value++;
        return value;
    }
    
    short incValue(int num){
        value+=num;
        return value;
    }
    
    short getValue(){
        return value;
    }
    
    
}


