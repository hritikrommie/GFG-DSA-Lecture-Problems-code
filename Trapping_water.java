import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Trapping_water {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        FastReader in = new FastReader();
        test a=new test();
        a.solve(in,out);
        out.close();
    }
}
//-------Main Code-----------//
class test {
    public void solve(FastReader in, PrintWriter out) {
        int n=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=0;
        right[n-1]=0;
        for(int i=1;i<n;i++){
            if(a[i-1]>left[i-1]){
                left[i]=a[i-1];
            }else{
                left[i]=left[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(a[i+1]>right[i+1]){
                right[i]=a[i+1];
            }else{
                right[i]=right[i+1];
            }
        }
        int sum=0;
        for(int i=1;i<n-1;i++){
            sum+=Math.min(left[i],right[i])-a[i];
        }
        out.println(sum);
    }

}
//--------------------------//
class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        while(st==null || !st.hasMoreElements()){
            try{
                st=new StringTokenizer(br.readLine());
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    Long nextLong(){
        return Long.parseLong(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    String nextLine(){
        String str="";
        try{
            str=br.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}
