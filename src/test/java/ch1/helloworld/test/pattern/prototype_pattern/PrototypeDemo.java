package ch1.helloworld.test.pattern.prototype_pattern;

import java.util.ArrayList;

import org.junit.Test;

public class PrototypeDemo {
	
	@Test
    public void shallowCopy() throws CloneNotSupportedException{
    	
        ArrayList<String> famMem = new ArrayList<String>(); // 家庭成员名单  
        famMem.add("Papa");  
        famMem.add("Mama");  
          
        // 创建初始简历  
        Resume resume1 = new Resume("Jobs", famMem);  
        resume1.setPersonal("Male", 26);  
        resume1.setWork("2013/8/1 - 2015/6/30", "Huawei");  
          
        // 通过简历1复制出简历2，并对家庭成员和工作经验进行修改  
        Resume resume2 = resume1.clone();  
        resume2.setName("Tom");
        resume2.setAge(8);
        resume2.famMem.add("Brother");  
        resume2.setWork("2015/7/1 - 2016/6/30", "Baidu");  
          
        resume1.display();  
        resume2.display();  
    }
	
	
	@Test
    public void deepCopy() throws CloneNotSupportedException{
    	
        ArrayList<String> famMem = new ArrayList<String>(); // 家庭成员名单  
        famMem.add("Papa");  
        famMem.add("Mama");  
          
        // 创建初始简历  
        DeepCopyResume resume1 = new DeepCopyResume("Jobs", famMem);  
        resume1.setPersonal("Male", 26);  
        resume1.setWork("2013/8/1 - 2015/6/30", "Huawei");  
          
        // 通过简历1复制出简历2，并对家庭成员和工作经验进行修改  
        DeepCopyResume resume2 = resume1.clone();  
        resume2.setName("Tom");
        resume2.setAge(8);
        resume2.famMem.add("Brother");  
        resume2.setWork("2015/7/1 - 2016/6/30", "Baidu");  
          
        resume1.display();  
        resume2.display();  
    }// main 
}
