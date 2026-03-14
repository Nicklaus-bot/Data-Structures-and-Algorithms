import java.io.*;
public class TwoStacksInArray{
    public static class TSIA{
        int tos1;
        int tos2;
        int [] data;

        TSIA(int cap){
            tos1 = -1;
            tos2 = cap;
            data = new int [cap];
        }

        void push1(int val){
            if(tos1 + 1 == tos2){
                System.out.println("Stack Overflow");
            }
            else{
                tos1 ++;
                data[tos1] = val;
            }
        }

        void push2(int val){
            if(tos2 - 1 == tos1){
                System.out.println("Stack Overflow");
            }
            else{
                tos2--;
                data[tos2] = val;
            }
        }

        int top1(){
            if(tos1 == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return data[tos1];
            }
        }

        int top2(){
            if(tos2 == data.length){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return data[tos2];
            }
        }

        int size1(){
            return tos1 + 1;
        }

        int size2(){
            return data.length - tos2;
        }

        int pop1(){
            if(tos1 == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2(){
            if(tos2 == data.length){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

    }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TSIA st = new TSIA(n);

        String str = br.readLine();

        while(str.equals("quit") == false){
            if(str.startsWith("push1")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            }
            else if(str.startsWith("pop1")){
                int val = st.pop1();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("top1")){
                int val = st.top1();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("size1")){
                System.out.println(st.size1());
            }
            else if(str.startsWith("push2")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            }
            else if(str.startsWith("pop2")){
                int val = st.pop2();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("top2")){
                int val = st.top2();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("size2")){
                System.out.println(st.size2());
            }
            str = br.readLine();
        }
    }
}