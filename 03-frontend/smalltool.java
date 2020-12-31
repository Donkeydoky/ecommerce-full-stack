import java.io.File;
 
public class smalltool {
    
    static String patternString ="";
    static String target = "";
    static String replacement = "";
	public static void main(String[] args) {
        patternString = "(.*)-luv2code(.*)";
        String path = args[0]; //要遍历的路径
        //System.out.println(path); 
        File file = new File(path);		//获取其file对象
        func(file,patternString);
    }

    private static void func(File file,String patternString) {
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
		for(File f:fs){
			if(f.isDirectory())	//若是目录，则递归打印该目录下的文件
				func(f,patternString);
            if(f.isFile()){
                String temp = f.getName();
                if (temp.matches(patternString)){
                    
                    temp = StringFilter(f.getName());
                    String destination = f.getParent()+"/"+temp;
                    System.out.println(destination);
                    File dest = new File(destination);
                    f.renameTo(dest);
                }
				//System.out.println(temp); //若是文件，直接打印文件名
            }		
		}
    }

    private static String StringFilter(String f){
        target = "-luv2code";
        f = f.replace(target, replacement);
        //System.out.println(f);
        return f;
    }
}