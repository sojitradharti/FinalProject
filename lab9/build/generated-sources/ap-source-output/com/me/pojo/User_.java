package com.me.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> fname;
	public static volatile SingularAttribute<User, String> lname;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> roleName;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Integer> status;

	public static final String FNAME = "fname";
	public static final String LNAME = "lname";
	public static final String PASSWORD = "password";
	public static final String ROLE_NAME = "roleName";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";

}

