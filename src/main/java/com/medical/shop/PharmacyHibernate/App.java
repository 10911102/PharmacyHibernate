package com.medical.shop.PharmacyHibernate;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medical.dao.IMedicineDAO;
import com.medical.dao.MedicineDAO;
import com.medical.pojo.Medicine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");	 
       IMedicineDAO medicineDAO=context.getBean("medicineDAO",IMedicineDAO.class);
       Medicine medicine=new Medicine();
       medicine.setName("paractimol");
       medicine.setBrand("Cipla");
      // medicineDAO.insert(medicine);
       Medicine medicine2=new Medicine();
       medicine2.setName("Citrizine");
       medicine2.setBrand("Cipla");
      // medicineDAO.insert(medicine2);
       for( Medicine medicine1:medicineDAO.getAll()) {
    	   System.out.println(medicine1);
       }
       for( Medicine medicine1:medicineDAO.getByName("Citrizine")) {
    	   System.out.println(medicine1);
       }
       medicineDAO.getById(1);
       System.out.println("Hello world");
       ((ClassPathXmlApplicationContext)context).close();
    }
}
