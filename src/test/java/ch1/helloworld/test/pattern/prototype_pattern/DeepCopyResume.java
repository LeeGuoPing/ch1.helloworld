
/**
 * @author liguoping
 *
 * 2018年5月15日-下午5:19:07
 *
 * @function 深拷贝重写clone方法,新建个对象
 */
package ch1.helloworld.test.pattern.prototype_pattern;

import java.util.ArrayList;
import java.util.List;

public class DeepCopyResume implements Cloneable {
	public String name = null;
	public Integer age = null;
	public String sex = null;
	public List<String> famMem = new ArrayList<String>();
	public WorkExperience work = null;

	public DeepCopyResume(String name,List<String> famMem) {
		this.name = name;
		this.famMem = famMem;
		work = new WorkExperience();
	}// Resume
	
	public void setName(String name) {  
        this.name = name;  
    }// setName  
      
    public void setPersonal(String sex, int age) {  
        this.age = age;  
        this.sex = sex;  
    }
    
    public void setAge(int age){
    	this.age = age;
    }
  
    public void setWork(String timeArea, String company) {  
        work.timeArea = timeArea;  
        work.company = company;  
    }// setWork  
      
    /** 
     * 重些clone()方法为public类型，并调用Object类的本地clone()方法。 
     */  
    @Override  
    public DeepCopyResume clone() throws CloneNotSupportedException {  
    	int age = this.age;  
        String sex = this.sex;  
        String name = new String(this.name);  
        List<String> famMem = new ArrayList<String>(this.famMem);  
          
        DeepCopyResume copy = new DeepCopyResume(name, famMem);   
        copy.setPersonal(sex, age);  
        copy.setWork(this.work.timeArea, this.work.company);  
        return copy;  
    }// clone  
      
    public void display() {  
        System.out.println(this.name + " " + this.sex + " " + this.age);  
        System.out.print("Family member: ");  
        for(String elem : famMem)  
            System.out.print(elem + " ");  
        System.out.println();  
        System.out.print("Work experience: " + this.work.timeArea);  
        System.out.println(" " + this.work.company);  
    }// display  
}