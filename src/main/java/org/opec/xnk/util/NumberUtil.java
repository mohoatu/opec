package org.opec.xnk.util;

import java.util.*;
import java.text.*;

public class NumberUtil {
	
	public static Integer getInterger(Object value)
	{
		try
		{
			return toInterger(value);
		}
		catch(ParseException ex)
		{
			return null;
		}
	}
	
	public static Integer toInterger(Object value) throws ParseException
	{
		if(value == null) return null;
		if(value instanceof Integer) return (Integer)value;
		
		if(value instanceof String)
        {
            if( "".equals( (String)value ) ) return null;
            return Integer.parseInt(value.toString());
        }
		
		return Integer.parseInt(value.toString());
		
	}

}


