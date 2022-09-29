//Operating Systems (6683) - Phase 1
//Group Members:
//   Ahmed Raza - 22787
//   Asad Virani - 22787
//   Danish Badar Qureshi - 22890

package osphase1;


public class MainMemory{
    // 	Memory addressing is 16 bits, 
    //	Memory is simulated by taking a byte (unsigned char) array of 64K
    byte[] MM = new byte[64000];
    
    //load and store
    //	All memory references are 
    //through Load and Store instructions between Memory and General purpose Registers
    
    
    //	Stack is of 50 bytes for each process
        
    
    byte getValue(int index){
        return MM[index];
    }
    
    void setValue(byte v, int index) {
        MM[index] = v;
    }
}
