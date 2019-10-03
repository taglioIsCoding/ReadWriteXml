/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaxml;

/**
 *
 * @author 72873486
 */
public class Student {
    //Student atributes
	private String name;
	private int age;
	private boolean sex;//false= mele true= famele
        private String telNumber;
	
	//constructor
	public Student(String name, int age, boolean sex, String telNumber){
		this.name = name;
		this.age = age;
		this.sex = sex;
                this.telNumber=telNumber;
	}
	//generic constructor
	public Student(){
		
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getTelNumber() {
        return telNumber;
    }
        
        
        
}
