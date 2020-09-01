package com.angBackend.libraryProject;

import org.hibernate.type.BigDecimalType;
import org.hibernate.type.BinaryType;
import org.hibernate.type.BooleanType;
import org.hibernate.type.ByteType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TextType;

public class Hibernate {

	public static StringType STRING = StringType.INSTANCE;
	public static LongType LONG = LongType.INSTANCE;
	public static DateType DATE = DateType.INSTANCE;
	public static FloatType FLOAT = FloatType.INSTANCE;
	public static IntegerType INTEGER = IntegerType.INSTANCE;
	public static BooleanType BOOLEAN = BooleanType.INSTANCE;
	public static DoubleType DOUBLE = DoubleType.INSTANCE;
	public static BinaryType BINARY = BinaryType.INSTANCE;
	public static ByteType BYTE = ByteType.INSTANCE;
	public static TextType TEXT = TextType.INSTANCE;
	public static BigDecimalType BIG_DECIMAL = BigDecimalType.INSTANCE;

}
