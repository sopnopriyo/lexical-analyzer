package pktFile;

import java.util.Stack;

public class Checker {
    
    
public Checker( ){}
    
public  boolean checkValid(char[] equ){
        int i,j=equ.length;
        Stack<Character> astack=new Stack<>();
        if(j==0)return false;

        for(i=0;i<j;i++){
            if(isOpen(equ[i])){
                if(!astack.isEmpty() && isNumber(astack.peek())){
                    return false;
                }
                astack.push(equ[i]);
            }else if(isNumber(equ[i])){
                
                if(equ[i]=='0' && astack.peek()=='/'){
                    return false;
                }
                astack.push(equ[i]);
                
            }else if(isOp(equ[i])){
                if(astack.isEmpty() || !isNumber(astack.peek())){
                    return false;
                }
                astack.push(equ[i]);
            }else if(isClose(equ[i])){
                if(astack.isEmpty() || !isNumber(astack.peek())){
                    return false;
                }
                while(!astack.isEmpty()){
                    char temp=astack.pop();
                    if(isOpen(temp)){
                        if(doMatch(temp,equ[i])){
                            break;
                        }else{
                            return false;
                        }
                    }else{
                        if(astack.isEmpty()){
                            return false;
                        }
                    }
                }
                astack.push('1');
            }else{
                return false;
            }
        }
        if(!astack.isEmpty() && !isNumber(astack.peek())) {
            return false;
        }
        while(!astack.isEmpty()){
            if(isOpen(astack.pop()))return false;
        }
         
        return true;
    }

    private  boolean isOpen(char c) {
        if(c=='(' || c=='[')return true;
        return false;
    }

    private  boolean isNumber(char c) {
        if(c>='0' && c<='9')return true;
        return false;
    }

    private  boolean isOp(char c) {
        if(c=='+' || c=='-' || c=='*' || c=='/')return true;
        return false;
    }

    private  boolean isClose(char c) {
        if(c==')' || c==']')return true;
        return false;
    }

    private  boolean doMatch(char temp, char c) {
        if((temp=='(' && c==')')||(temp=='[' && c==']'))return true;
        return false;
    }

    
   
}
