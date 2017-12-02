//     class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         return helper(candidates,target,candidates.length - 1);
//     }

//     List<List<Integer>> helper(int[] c, int x, int index) {
//         List<List<Integer>> result = new LinkedList<>();
//         boolean flag = true;
//         for(;index > -1;index--) {
//             if(c[index] <= x) {
//                 flag = false;
//                 break;
//             }
//         }
//         if(flag) return result;
        
//         if(c[index] == x) {
//             List<Integer> l1 = new LinkedList<>();
//             l1.add(x);
//             result.add(l1);
//         }
//         List<List<Integer>> result1 = helper(c,x-c[index],index);
//         if(result1.size() != 0) {
//             for(List l2 : result1) {
//                 l2.add(c[index]);
//                 result.add(l2);
//             }
//         }
//         result1 = helper(c,x,index-1);
//         if(result1.size() != 0) {
//             for(List l2 : result1) {
//                 result.add(l2);
//             }
//         }
//         return result;
//     }
// }





class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = helper(candidates,target);
        if(result == null) return new LinkedList<>();
        else return result;
    }

    List<List<Integer>> helper(int[] c, int x) {
        List<List<Integer>> result = new LinkedList<>();
        
        int n = c.length;
        int i;
        for(i = n-1;i >= -1;i--) {
            if(i == -1) {
                return null;
            }
            if(c[i] <= x) break;
        }
        int[] subC = new int[i+1];
        int[] ssubC = new int[i];
        System.arraycopy(c,0,subC,0,i+1);
        System.arraycopy(c,0,ssubC,0,i);
        if(c[i] == x) {
            List<Integer> list = new LinkedList<>();
            list.add(x);
            result.add(list);
            if(helper(ssubC,x) != null) {
                for(List l1 : helper(ssubC,x)) {
                    result.add(l1);
                }
            } return result;
        } else {
            List<List<Integer>> result1 = helper(ssubC,x);
            
            if(result1 != null) {
                for(List l1 : result1) {
                    result.add(l1);
                }
            }
            List<List<Integer>> result2 = helper(subC,x-c[i]);
            if(result2 != null) {
                for(List l1 : result2) {
                    l1.add(c[i]);
                    result.add(l1);
                }
            }
            return result;
        }
    }
}
