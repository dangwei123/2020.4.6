判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] block=new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int a=board[i][j]-'1';
                    int index=i/3*3+j/3;
                    if(row[i][a]||col[j][a]||block[index][a]){
                        return false;
                    }
                    row[i][a]=true;
                    col[j][a]=true;
                    block[index][a]=true;
                }
                
            }
        }
        return true;
    }
}

给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i]=tmp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp=matrix[j][i];
                matrix[j][i]=matrix[n-1-j][i];
                matrix[n-1-j][i]=tmp;
            }
        }
    }
    //private void swap(int[][] matrix,int )
}

class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=tmp;
            }
        }
    }
}

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
class Solution {
    public int reverse(int x) {
        
        boolean flag=false;
        if(x<0){
            flag=true;
            x=-x;
        }
        int res=0;
        while(x!=0){
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&x>7)){
                return 0;
            }
            if(flag&&(res<Integer.MIN_VALUE/10||                   (res==Integer.MIN_VALUE/10&&x>8))){
                return 0;
            }
            res=res*10+x%10;
            x/=10;
        }
        return flag?-res:res;
    }
}

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
class Solution {
    public boolean isAnagram(String s, String t) {
        List<Character> list=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(list.isEmpty()||!list.contains(c)){
                return false;
            }
            list.remove(Character.valueOf(c));
        }
        return list.isEmpty();
    }
}

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。
class Solution {
    public boolean isPalindrome(String s) {
        int len=s.length();
        if(len==0) return true;
        int left=0;
        int right=len-1;
        while(left<right){
            while(left<right&&!isValid(s.charAt(left))){
                left++;
            }
            while(left<right&&!isValid(s.charAt(right))){
                right--;
            }
            char l=s.charAt(left);
            char r=s.charAt(right);
            if(l==r||((l<'0'||l>'9')&&(r<'0'||r>'9')&&Math.abs(l-r)==32)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char r){
        return (r>='a'&&r<='z')||(r>='A'&&r<='Z')||(r>='0'&&r<='9');
    }
}