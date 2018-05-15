
/**
 * @author liguoping
 *
 * 2018年5月15日-下午5:19:07
 *
 * @function 浅拷贝: 对象中引用类型共有一个.修改一个另一个也会随之改变
 */
package ch1.helloworld.test.pattern.prototype_pattern;

import java.util.ArrayList;
import java.util.List;

public class Resume implements Cloneable {
	public String name = null;
	public Integer age = null;
	public String sex = null;
	public List<String> famMem = new ArrayList<String>();
	public WorkExperience work = null;

	public Resume(String name,List<String> famMem) {
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
    public Resume clone() throws CloneNotSupportedException {  
        return (Resume)super.clone();   
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