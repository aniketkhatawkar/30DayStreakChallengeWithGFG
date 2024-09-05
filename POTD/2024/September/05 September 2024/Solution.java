class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        // Your Code Here
        Arrays.sort(arr);
        
        for(int i=0;i<n-1;++i) 
            if(arr[i]!=i+1) 
                return i+1;
                
        return n;
    }
}