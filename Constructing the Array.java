//Raj Jain

import java.util.*;
import java.io.*;
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

class ConstructingtheArray
{   
    static class pair{
        int x,y;
        pair(int p, int q){
            x=p;
            y=q;
        }
    }
    public static void main(String[] args) throws IOException {
        Reader sc=new Reader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            PriorityQueue<pair> q = new PriorityQueue<pair>((a,b) ->{
                if((b.y - b.x) > (a.y - a.x))return 1;
                if((b.y - b.x) < (a.y - a.x))return -1;
                return (a.x - b.x);
            });
            q.add(new pair(0,n-1));
            int i =0;
            while(q.size() > 0){
                pair now = q.poll();
                int r = now.y;
                int l = now.x;
                int mid = 0;
                if((r-l+1)%2 != 0){
                    mid = (l+r)/2;
                    arr[mid] = ++i;
                }
                else{
                    mid = (l+r-1)/2;
                    arr[mid] = ++i;
                }
                if(l != mid){
                    q.add(new pair(l, mid-1));
                }
                if(r != mid){
                    q.add(new pair(mid+1, r));
                }
            }
            for(int xyz: arr)
                out.print(xyz+" ");
            out.println();
        }
        out.close();
    }
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        BufferedReader br; 
        private int bufferPointer, bytesRead; 

        public Reader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in));
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public String nextLine() throws IOException
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 

        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 

            if (neg) 
                return -ret; 
            return ret; 
        } 

        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 

        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 

            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 

            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 

            if (neg) 
                return -ret; 
            return ret; 
        } 

        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 

        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 

        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
}
