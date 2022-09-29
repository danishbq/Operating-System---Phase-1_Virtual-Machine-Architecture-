//Operating Systems (6683) - Phase 1
//Group Members:
//   Ahmed Raza - 22787
//   Asad Virani - 22787
//   Danish Badar Qureshi - 22890

package osphase1;

public class Instruction {
    //private MainMemory memory;
    
    Register r1 = new GPR();
    Register r2 = new GPR(); 
    //Flag flag = new Flag();
    //Register pc = new Register();
    //Register cb = new Register();
    MainMemory memory;
    Register[] gpr;
    Register[] spr;
    Flag flag;
     
    public Instruction(MainMemory memory, Register[] gpr, Register[] spr, Flag flag) { 
        this.memory = memory;
        this.gpr = gpr;
        this.spr = spr;
        this.flag = flag;
        spr[10].setValue((short)0);
        spr[1].setValue((short)0);
        
    }

    //Instruction(MainMemory mymemory, Register[] myspr, Register[] myspr0, Register myflag) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
        
    void mov(){
        spr[10].incValue(3);            //spr[10] is PC.. it is incremented as mov has 3 byte instruction
        short t1=spr[1].incValue(); //1  //memory index where the code is present
        short t2= spr[1].incValue(); //2  // "
        
//        t1 = memory.getValue(t1);
//        t2 = memory.getValue(t2);
//        gpr[t1].setValue(gpr[t2].getValue());
//        //r1.setValue((short) r2.getValue());
//        spr[1].setValue(spr[10].getValue()); // spr[1] is CB..setting code base equal to pc
//       // System.out.println("done");

        short m1 = (short) (memory.getValue(t1));     
        short m2 = (short) (memory.getValue(t2));     
        
        gpr[m1].setValue(gpr[m2].getValue());
        
        spr[1].setValue(spr[10].getValue());
        
    }
    void add(){
        spr[10].incValue(3);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        
        short m1 = (short) (memory.getValue(t1));     
        short m2 = (short) (memory.getValue(t2));     
        
        short value = (short)(gpr[m1].getValue() + gpr[m2].getValue());
        
        gpr[m1].setValue(value);
        
        spr[1].setValue(spr[10].getValue());

//        r1.setValue((short) (r1.getValue()+r2.getValue()));
    }
    void sub(){
        spr[10].incValue(3);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        
        short m1 = (short) (memory.getValue(t1));     
        short m2 = (short) (memory.getValue(t2));     
        
        short value = (short)(gpr[m1].getValue() - gpr[m2].getValue());
        
        gpr[m1].setValue(value);
        
        spr[1].setValue(spr[10].getValue());    
    }
    
    void mul(){
        spr[10].incValue(3);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        
        short m1 = (short) (memory.getValue(t1));     
        short m2 = (short) (memory.getValue(t2));     
        
        short value = (short)(gpr[m1].getValue() * gpr[m2].getValue());
        
        gpr[m1].setValue(value);
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void div(){
        spr[10].incValue(3);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 

        short m1 = (short) (memory.getValue(t1));     
        short m2 = (short) (memory.getValue(t2));     
        
        short value = (short)(gpr[m1].getValue() / gpr[m2].getValue());
        
        gpr[m1].setValue(value);
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void logor(){
        spr[10].incValue(3);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        
        short m1 = (short) (memory.getValue(t1));     
        short m2 = (short) (memory.getValue(t2));     
        
        short value = (short)(gpr[m1].getValue() | gpr[m2].getValue());
        
        gpr[m1].setValue(value);
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void logand(){
        spr[10].incValue(3);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        
//        t1 = memory.getValue(t1);
//        t2 = memory.getValue(t2);
        short m1 = (short) (memory.getValue(t1));     //m1 is the register number
        short m2 = (short) (memory.getValue(t2));     //m2 is the register number
        
        short andValue = (short)(gpr[m1].getValue() & gpr[m2].getValue());
        
        gpr[m1].setValue(andValue);    //setting the final result in register m1
        
//        gpr[t1].setValue((short) (gpr[t1].getValue() & gpr[t2].getValue()));       
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void movi(){
        //System.out.println("I am movi");
        spr[10].incValue(4);
        short t1=spr[1].incValue();    //register
        //System.out.println("t1 is " + t1);
        short t2= spr[1].incValue();   //1st byte (e.g 15)
        //System.out.println("t2 is " + t2);
        short t3 = spr[1].incValue();  //2nd byte (e.g 23)   -> means mov (1523) short into register t1
        // System.out.println("t3 is " + t3);
        
//        t2 = (short) (t2*100);   //to concatinate in 100s place
//        
//        short value = (short)(t2 + t3);
        short m2 = (short) (memory.getValue(t2)*100);
       // System.out.println("m2 is " + m2);
        short m3 = (short) (memory.getValue(t3));
       // System.out.println("m3 is " + m3);
        short value = (short) (m2 + m3);
       // System.out.println("value is " + value);

        gpr[memory.getValue(t1)].setValue(value);
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void addi(){
        spr[10].incValue(4);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        short t3 = spr[1].incValue();
        
        short m2 = (short) (memory.getValue(t2) * 100);  
        short m3 = (short) (memory.getValue(t3)); 
        short value = (short)(m2 + m3); 

        int gprIndex = memory.getValue(t1);
        gpr[gprIndex].setValue((short)(gpr[gprIndex].getValue() + value));
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void subi(){
        spr[10].incValue(4);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        short t3 = spr[1].incValue();
        
        short m2 = (short) (memory.getValue(t2) * 100);  
        short m3 = (short) (memory.getValue(t3)); 
        short value = (short)(m2 + m3); 

        int gprIndex = memory.getValue(t1);
        gpr[gprIndex].setValue((short)(gpr[gprIndex].getValue() - value));
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void muli(){
        spr[10].incValue(4);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        short t3 = spr[1].incValue();
        
//        t2 = (short) (t2*100);   //to concatinate in 100s place
//        
//        short value = (short)(t2 + t3);
        
        short m2 = (short) (memory.getValue(t2) * 100);  //getting the immediate value from memory at location t2 (100s place)
        short m3 = (short) (memory.getValue(t3));   //similar as above (1s position)
        short value = (short)(m2 + m3);   //final value

        int gprIndex = memory.getValue(t1);  //getting the register number from memory to store value at
        gpr[gprIndex].setValue((short)(gpr[gprIndex].getValue() * value));
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void divi(){
        spr[10].incValue(4);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        short t3 = spr[1].incValue();
        
        short m2 = (short) (memory.getValue(t2) * 100);  //getting the immediate value from memory at location t2 (100s place)
        short m3 = (short) (memory.getValue(t3));   //similar as above (1s position)
        short value = (short)(m2 + m3);   //final value

        int gprIndex = memory.getValue(t1);  //getting the register number from memory to store value at
        gpr[gprIndex].setValue((short)(gpr[gprIndex].getValue() / value));
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void andi(){
        spr[10].incValue(4);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        short t3 = spr[1].incValue();
        
        short m2 = (short) (memory.getValue(t2) * 100);  
        short m3 = (short) (memory.getValue(t3)); 
        short value = (short)(m2 + m3); 

        int gprIndex = memory.getValue(t1);
        gpr[gprIndex].setValue((short)(gpr[gprIndex].getValue() & value));
        
        spr[1].setValue(spr[10].getValue());
    }
    
    void ori(){
        spr[10].incValue(4);
        short t1=spr[1].incValue(); 
        short t2= spr[1].incValue(); 
        short t3 = spr[1].incValue();
        
        short m2 = (short) (memory.getValue(t2) * 100);  
        short m3 = (short) (memory.getValue(t3)); 
        short value = (short)(m2 + m3); 

        int gprIndex = memory.getValue(t1);
        gpr[gprIndex].setValue((short)(gpr[gprIndex].getValue() & value));
        
        spr[1].setValue(spr[10].getValue());
    }
    
     void bz(){
        //spr[10].incValue(3);
        //short t3 = spr[1].incValue();
        
         if(flag.getzero()) {
            short t1=spr[1].incValue();   
            short t2= spr[1].incValue();  
            
//            short index = (short)(t1 + t2);

            short m1 = (short) (memory.getValue(t1));   //base  
            short m2 = (short) (memory.getValue(t2));   //offset
           
            short index = (short)(m1 + m2);

            spr[10].setValue(index);
         }
         else
             spr[10].incValue(3);
         
         spr[1].setValue(spr[10].getValue());
         
     }
     
     void bnz(){        
        if(!flag.getzero()) {
            short t1=spr[1].incValue();    
            short t2= spr[1].incValue();   
            
            short m1 = (short) (memory.getValue(t1));   //base  
            short m2 = (short) (memory.getValue(t2));   //offset
           
            short index = (short)(m1 + m2);

            spr[10].setValue(index);
        }
        else
            spr[10].incValue(3);
         
        spr[1].setValue(spr[10].getValue());
     }
     
    void bc(){
        if(flag.getcarry()) {
            short t1=spr[1].incValue();    
            short t2= spr[1].incValue();   
            
            short m1 = (short) (memory.getValue(t1));   //base  
            short m2 = (short) (memory.getValue(t2));   //offset
           
            short index = (short)(m1 + m2);

            spr[10].setValue(index);
         }
         else
             spr[10].incValue(3);
         
         spr[1].setValue(spr[10].getValue());
     }
     
    void bs(){
         if(flag.getsign()) {
            short t1=spr[1].incValue();    
            short t2= spr[1].incValue();   
            
            short m1 = (short) (memory.getValue(t1));   //base  
            short m2 = (short) (memory.getValue(t2));   //offset
           
            short index = (short)(m1 + m2);

            spr[10].setValue(index);
        }
        else
            spr[10].incValue(3);
         
        spr[1].setValue(spr[10].getValue());
    }
     
    void jmp() {
        short t1=spr[1].incValue();    
        short t2= spr[1].incValue();   
            
        short m1 = (short) (memory.getValue(t1));   //base  
        short m2 = (short) (memory.getValue(t2));   //offset
        
        short index = (short)(m1 + m2);

        spr[10].setValue(index);
        
        spr[1].setValue(spr[10].getValue());

    }
     
    void movl() {
        spr[10].incValue(4);  
        short t1=spr[1].incValue();  
        short t2= spr[1].incValue();  
        short t3 = spr[1].incValue();  
        
        short m1 = (short) (memory.getValue(t1));   //register 
        short m2 = (short) (memory.getValue(t2));   //base
        short m3 = (short) (memory.getValue(t3));   //offset
        
        short index = (short) (m2 + m3);
        gpr[m1].setValue(memory.getValue(index));
        
        //gpr[t1].setValue((short)(gpr[t1].getValue() | value));
        
        spr[1].setValue(spr[10].getValue());
//         byte b = memory.getValue(num);
//         Byte a = new Byte(b);
//         short temp = a.shortValue();
//         r1.setValue(temp);
         
         //r1.setValue(memory[num].shortValue());
    }
     
    void movs() {
        spr[10].incValue(4);  
        short t1=spr[1].incValue();   //register
        short t2= spr[1].incValue();  //base
        short t3 = spr[1].incValue();  //offset
        
        short m1 = (short) (memory.getValue(t1));   //register 
        short m2 = (short) (memory.getValue(t2));   //base
        short m3 = (short) (memory.getValue(t3));   //offset
        
        short index = (short) (m2 + m3);
        memory.setValue((byte)(gpr[m1].getValue()), index);
                
        spr[1].setValue(spr[10].getValue());
        
//         short a = r1.getValue();
//         byte b = (byte)a;
//         memory.setValue(b, num);
     }
     
    private void helper_muli(Register r1, int num){    //helper methods for shifting
        r1.setValue((short) (r1.getValue()*num));
    }
    private void helper_divi(Register r1, int num){
        r1.setValue((short) (r1.getValue()/num));
    }
    
    void shl() {
        spr[10].incValue(2);  
        short t1=spr[1].incValue();
        
        short m1 = (short) (memory.getValue(t1)); //register
        
        helper_muli(gpr[m1], 2);
        spr[1].setValue(spr[10].getValue());

    }
     
     void shr() {
        spr[10].incValue(2);  
        short t1=spr[1].incValue(); 
        
        short m1 = (short) (memory.getValue(t1)); //register
        
        helper_divi(gpr[m1], 2);
        spr[1].setValue(spr[10].getValue());
     }
     
     void rtl() {
        spr[10].incValue(2);
        short t1=spr[1].incValue();
        
        short m1 = (short) (memory.getValue(t1)); //register
        
        gpr[m1].setValue((short) (Integer.rotateLeft(gpr[m1].getValue(), 1)));
        spr[1].setValue(spr[10].getValue());
     }
     
     void rtr() {
        spr[10].incValue(2);
        short t1=spr[1].incValue();
        
        short m1 = (short) (memory.getValue(t1)); //register
        
        gpr[m1].setValue((short) (Integer.rotateRight(gpr[m1].getValue(), 1)));
        spr[1].setValue(spr[10].getValue());
     }
     
     void inc(){
        spr[10].incValue(2);
        short t1=spr[1].incValue();
        
        short m1 = (short) (memory.getValue(t1)); //register
        
        gpr[m1].setValue((short) (gpr[m1].getValue() + 1));
        spr[1].setValue(spr[10].getValue());
     }
     
     void dec(){
        spr[10].incValue(2);
        short t1=spr[1].incValue();
        
        short m1 = (short) (memory.getValue(t1)); //register
        
        gpr[m1].setValue((short) (gpr[m1].getValue() - 1));
        spr[1].setValue(spr[10].getValue());
     }
     
    void noop() {
        spr[10].incValue(1);
        spr[1].setValue(spr[10].getValue());
    }
    
    void end() {
        System.out.println("End of Process");
    }
       
    
}