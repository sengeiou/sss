/**  
 * File Name:Builder.java  
 * Package Name:com.zhoufb.test.testmoshi  
 * Description: (That's the purpose of the file)
 * Date:2018年6月1日上午10:08:52  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:Builder.java  
 * Package Name:com.zhoufb.test.testmoshi  
 * Description: That's the purpose of the file
 * Date:2018年6月1日上午10:08:52  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.test.testmoshi;  
/**  
 * ClassName:Builder <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年6月1日 上午10:08:52 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: Builder <br/>  
 * date: 2018年6月1日 上午10:08:52 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class Builder {

    static class Student{
        String name = null ;
        int number = -1 ;
        String sex = null ;
        int age = -1 ;
        String school = null ;

        static class StudentBuilder{
            String name = null ;
            int number = -1 ;
            String sex = null ;
            int age = -1 ;
            String school = null ;
            public StudentBuilder setName(String name) {
                this.name = name;
                return  this ;
            }

            public StudentBuilder setNumber(int number) {
                this.number = number;
                return  this ;
            }

            public StudentBuilder setSex(String sex) {
                this.sex = sex;
                return  this ;
            }

            public StudentBuilder setAge(int age) {
                this.age = age;
                return  this ;
            }

            public StudentBuilder setSchool(String school) {
                this.school = school;
                return  this ;
            }
            public Student build() {
                return new Student(this);
            }
        }

        public Student(StudentBuilder builder){
            this.age = builder.age;
            this.name = builder.name;
            this.number = builder.number;
            this.school = builder.school ;
            this.sex = builder.sex ;
        }
    }

    public static void main( String[] args ){
        Student a = new Student.StudentBuilder().setAge(13).setName("LiHua").build();
        Student b = new Student.StudentBuilder().setSchool("sc").setSex("Male").setName("ZhangSan").build();
    }

}
  
