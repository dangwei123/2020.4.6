public class FileOperation {
    @Test
    public void test1() throws IOException {
        File file=new File("E:\\ideaProjests\\20200405\\info.txt");
        FileInputStream fis=new FileInputStream(file);
        byte[] bytes=new byte[1024];
        while((fis.read(bytes))!=-1){
            String s=new String(bytes);
            System.out.println(s);
        }
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fis=null;
        BufferedInputStream bis=null;
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;
        try {
            File file = new File("E:\\ideaProjests\\20200405\\info.txt");
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            File f = new File("E:\\ideaProjests\\20200405\\copy.txt");
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            while (bis.read(bytes) != -1) {
                bos.write(bytes);
                bos.flush();
            }
        }
        finally{
            if(bis!=null)  bis.close();
            if(fis!=null) fis.close();
            if(bos!=null) bos.close();
            if(fos!=null) fos.close();
        }

    }

    @Test
    public void test3() throws IOException {
        File file=new File("E:\\ideaProjests\\20200405\\info.txt");
        FileReader fr=new FileReader(file);
        char[] chars=new char[1024];
        while((fr.read(chars))!=-1){
            String s=new String(chars);
            System.out.println(s);
        }
    }

    @Test
    public void test4() throws IOException {
        File file=new File("E:\\ideaProjests\\20200405\\info.txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        char[] chars=new char[1024];
        while((br.read(chars))!=-1){
            String s=new String(chars);
            System.out.println(s);
        }
    }

    @Test
    public void test5() throws IOException {
        InputStream in=System.in;
        InputStreamReader fr=new InputStreamReader(in);
        BufferedReader br=new BufferedReader(fr);

        File file=new File("E:\\ideaProjests\\20200405\\info.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        char[] chars=new char[1024];
        while((br.read(chars))!=-1){
            String s=new String(chars);
            if(s.equals("exit")){
                break;
            }
            bw.write(chars);
            bw.flush();
        }

        br.close();
        bw.close();
    }
}


给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[m][n];
    }
}

