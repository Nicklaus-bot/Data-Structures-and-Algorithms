class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        int [] res = new int [n + m];  
        for(int a=0 ; a<res.length ; a++){  
            while(i<m && j<n){
                if(nums1[i] < nums2[j]){
                    res[a] = nums1[i];
                    i++;
                }
                else{
                    res[a] = nums2[j];
                    j++;
                }
            }

            while(i<m){
                res[a] = nums1[i];
                i++;
            }

            while(j<n){
                res[a] = nums2[j];
                j++;
            }
        }

        for(int b=0 ; b<nums1.length ; b++){
            nums1[b] = res[b];
        }

    }
}