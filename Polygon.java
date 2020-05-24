//Raj Jain
 
import java.util.*;
import java.io.*;
 
public class Polygon
{
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); 
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            sc.nextLine();
            char arr[][] = new char[n+2][n+2];
            for(int i = 1; i<=n; i++){
                arr[i][0] ='1';
                arr[i][n+1] ='1';
                String s = sc.nextLine();
                for(int j = 0; j<n ;j++)
                    arr[i][j+1] = s.charAt(j);
            }
            boolean ans = true;
            OUTER: for(int i = n-1; i>=0; i--){
                for(int j = n; j>=1; j--){
                    if(arr[i][j] == '1'){
                        if(arr[i+1][j] != '1' && arr[i][j+1] != '1'){
                            ans = false;
                            break OUTER;
                        }
                    }
                }
            }
            out.println(ans ? "YES" : "NO");
        }
        out.close();
    }
}