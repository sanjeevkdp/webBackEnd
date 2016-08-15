//package com.niit.test;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.dao.UserDetailsDao;
//import com.niit.model.UserDetails;
//
//
//public class UserDetailsTest {
//
//		public static void main(String[] args) {
//			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//			context.scan("com.niit");
//			context.refresh();
//	    UserDetails userDetails= (UserDetails) context.getBean("userDetails");
//        UserDetailsDao userDetailsDao= (UserDetailsDao) context.getBean("userDetailsDao");
//        userDetails.setUser_id("USR02");
//        userDetails.setUser_name("Ahmad");
//        userDetails.setUser_email("ahmad@gmail.com");
//        userDetails.setUser_address("i lived in Bhandup");
//        userDetails.setUser_contact(null);
//        userDetails.setUser_gender("male");
//        userDetails.setUser_imageurl("default.jpg");
//        userDetails.setUser_password("asjkd12");
//    userDetailsDao.saveOrUpdate(userDetails);
//		}
//}
