//Operating Systems (6683) - Phase 1
//Group Members:
//   Ahmed Raza
//   Asad Virani
//   Danish Badar Qureshi

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


