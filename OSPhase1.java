//Operating Systems (6683) - Phase 1
//Group Members:
//   Ahmed Raza - 22787
//   Asad Virani - 22787
//   Danish Badar Qureshi - 22890

package osphase1;

public class OSPhase1 {
    public static void main(String[] args)  {
        MainMemory mymemory = new MainMemory();
        
        byte[] arr ={(byte)0x30, (byte)0x1, (byte)0x0,  (byte)0x1, 
            (byte)0x30, (byte)0x2, (byte)0x7F, (byte)0xFF, (byte)0x19, (byte)0x1, (byte)0x2,
        (byte)0xF3};
        
//byte[] arr ={0x16, 0x01, 0x02, (byte)0xF3};
        for (int i = 0; i < arr.length; i++) {
            mymemory.setValue(arr[i], i);
            
        }
        
        //printing main memory for checking
        System.out.println("Memory contents are ");
        for (int i = 0; i < 20; i++) {
            System.out.print(mymemory.getValue(i) + " ");
            
        }
        // Creating and initialising GPR
        Register[] mygpr= new Register[16];
        //GPR[0] = new Register();
        //GPR[1] = new Register();
        for (int i = 0; i < mygpr.length; i++) {
            mygpr[i]= new GPR();
            
        }
//        mygpr[2].setValue((short)34);
        /*
        The value of first register is always Zero 0
    	Three registers for code (base 01, limit 02, & counter 03)
	Three registers for stack (base 04, limit 05, & counter 06)
	Two registers for data (base 07 & limit 08)
	One register for flags 09
	Six Registers reserved for future use
        */
        //
        // Creating and initialising SPR
        Register[] myspr= new Register[15];
        for (int i = 0; i < myspr.length; i++) {
            myspr[i]= new SPR();
            
        }
        Register myflag = new Flag();
        Instruction w = new Instruction(mymemory, mygpr, myspr, (Flag) myflag);
        
        System.out.println("");
        //setting code base and PC
        myspr[1].setValue((short)0);
        //setting code counter
        myspr[3].setValue((short)11);
        //mygpr[2].setValue((short)23);
        //Instruc w = new Instruc();
        byte mread = mymemory.MM[myspr[1].getValue()];
        //while opcode is not end/ f3/243
        
        while(mread!=(byte)(0xF3) || myspr[10].getValue()<=myspr[3].getValue()){
            //IR
            if(mread==0x16) {
                //System.out.println("test1");
                w.mov();
            }
            else if (mread==0x17)
                w.add();
            else if (mread==0x18)
                w.sub();
            else if (mread==0x19){
                //System.out.println("test2");
                w.mul();
            }
            else if (mread==(byte)0x1A)
                w.div();
            else if (mread==(byte)0x1B)
                w.logand();
            else if (mread==(byte)0x1C)
                w.logor();
            else if (mread==(byte)0x30) {
                w.movi();
            //    System.out.println("test1");
            }
            else if (mread==(byte)0x31)
                w.addi();
            else if (mread==(byte)0x32)
                w.subi();
            else if (mread==(byte)0x33)
                w.muli();
            else if (mread==(byte)0x34)
                w.divi();
            else if (mread==(byte)0x35)
                w.andi();
            else if (mread==(byte)0x36)
                w.ori();
            else if (mread==(byte)0x37)
                w.bz();
            else if (mread==(byte)0x38)
                w.bnz();
            else if (mread==(byte)0x39)
                w.bc();
            else if (mread==(byte)0x3A)
                w.bs();
            else if (mread==(byte)0x3B)
                w.jmp();
            else if (mread==(byte)0x51)
                w.movl();
            else if (mread==(byte)0x52)
                w.movs();
            else if (mread==(byte)0x71)
                w.shl();
            else if (mread==(byte)0x72)
                w.shr();
            else if (mread==(byte)0x73)
                w.rtl();
            else if (mread==(byte)0x74)
                w.rtr();
            else if (mread==(byte)0x75)
                w.inc();
            else if (mread==(byte)0x76)
                w.dec();
            else if (mread==(byte)0xF2)
                w.noop();
            else if (mread==(byte)0xF3) {
                //System.out.println("test3");
                break;
            }
             
           
             mread = mymemory.MM[myspr[10].getValue()];
        }
       
        System.out.print("GPR ");
        for (int i = 0; i <mygpr.length; i++) {
            System.out.print(mygpr[i].getValue()+ " ");
            
        }
        System.out.println("");
        System.out.print("SPR ");
        for (int i = 0; i <myspr.length; i++) {
            System.out.print(myspr[i].getValue()+ " ");
            
        }
            
    }
 
        
}


