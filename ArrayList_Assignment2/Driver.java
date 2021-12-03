import java.util.*;

public class Driver{
    
    public static void main(String[] args){
        System.out.println(listPrimes(100));
        System.out.println(listPrimes(30));
        goldbach(98);
        goldbach(22);
        System.out.println(BigInts(
        new ArrayList<Integer>(){{add(9);add(8);add(1);}}
        ,new ArrayList<Integer>(){{add(7);add(2);add(6);}}));
        System.out.println(BigInts(
        new ArrayList<Integer>(){{add(3);add(7);add(8);}},
        new ArrayList<Integer>(){{add(2);add(6);add(4);add(9);}}
        ));
    }

    public static ArrayList<Integer> listPrimes(int n){
        ArrayList<Integer> primes=new ArrayList<Integer>();
        ArrayList<Integer> nums=new ArrayList<Integer>();
        for(int i=2;i<=n;i++)primes.add(i);
        int p=2;
        while(!primes.isEmpty()){
            for(int i=1;i<primes.size();){
                int num = primes.get(i);
                if(num%p==0)primes.remove(i);
                else i++;
            }
            if(primes.size()>0){
                nums.add(primes.get(0));
                p=primes.remove(0);
            }
        }
        return nums;
    }
    
    public static void goldbach(int n){
        ArrayList<Integer> primeList = listPrimes(n);
        int num1=0,num2=0;
        for(int i=0;i<primeList.size();i++){
            if(primeList.indexOf(n-i)!=-1){
                System.out.println((n-i)+" + "+i+" = "+n);
                break;
            }
        }
    }
    
    public static ArrayList<Integer> BigInts(ArrayList<Integer> big1,ArrayList<Integer> big2){
        if(big1.size()>big2.size()){
            ArrayList<Integer> newBig = new ArrayList<Integer>();
            for(int i=0;i<big1.size();++i){
                if(i>=big1.size()-big2.size()){
                    if(big1.get(i)+big2.get(i-(big1.size()-big2.size()))>=10){
                       newBig.set(newBig.size()-1,newBig.get(newBig.size()-1)+1);
                       newBig.add((big1.get(i)+big2.get(i-(big1.size()-big2.size())))%10);
                   }else newBig.add(big1.get(i)+big2.get(i));
                }else{
                    newBig.add(big1.get(i));
                }
            }for(int i=0;i<newBig.size();++i){
                if(newBig.get(i)>=10){
                    if(i==0){
                        newBig.add(0,newBig.get(0)+1);
                        newBig.set(1,newBig.get(i)%10);
                    }else{
                        newBig.set(i-1,newBig.get(i-1)+1);
                        newBig.set(i,newBig.get(i)%10);
                    }
                }
            }return newBig;
        }else if(big1.size()<big2.size()){
            ArrayList<Integer> newBig = new ArrayList<Integer>();
            for(int i=0;i<big2.size();i++){
                if(i>=big2.size()-big1.size()){
                   if(big1.get(i-(big2.size()-big1.size()))+big2.get(i)>=10){
                            newBig.set(newBig.size()-1,newBig.get(newBig.size()-1)+1);
                            newBig.add((big1.get(i-(big2.size()-big1.size()))+big2.get(i))%10);
                   }else newBig.add(big1.get(i-(big2.size()-big1.size()))+big2.get(i));
                }else{
                    newBig.add(big2.get(i));
                }
            }for(int i=0;i<newBig.size();++i){
                if(newBig.get(i)>=10){
                    if(i==0){
                        newBig.add(0,newBig.get(0)+1);
                        newBig.set(1,newBig.get(i)%10);
                    }else{
                        newBig.set(i-1,newBig.get(i-1)+1);
                        newBig.set(i,newBig.get(i)%10);
                    }
                }
            }
            return newBig;
        }else{
            ArrayList<Integer> newBig = new ArrayList<Integer>();
            for(int i=0;i<big2.size();i++){
                   if(big1.get(i)+big2.get(i)>=10||big1.get(i)+big2.get(i)+newBig.get(newBig.size()-1)>=10){
                        if(newBig.isEmpty()){
                            newBig.add(1);
                            newBig.add((big1.get(i)+big2.get(i))%10);
                        }
                        else {
                            newBig.set(newBig.size()-1,newBig.get(newBig.size()-1)+1);
                            newBig.add((big1.get(i)+big2.get(i))%10);
                        }
                   }else{
                       newBig.add(big1.get(i)+big2.get(i));
                   }
            }for(int i=0;i<newBig.size();++i){
                if(newBig.get(i)>=10){
                    if(i==0){
                        newBig.add(0,newBig.get(0)+1);
                        newBig.set(1,newBig.get(i)%10);
                    }else{
                        newBig.set(i-1,newBig.get(i-1)+1);
                        newBig.set(i,newBig.get(i)%10);
                    }
                }
            }return newBig;
        }
    }
}