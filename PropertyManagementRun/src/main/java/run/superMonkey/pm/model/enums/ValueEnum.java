package run.superMonkey.pm.model.enums;

import org.springframework.util.Assert;

/**
 * Interface for value enum
 * @author 彭俊豪(Peng Jun Hao)
 *
 * @param <T> value Type
 * 
 */
public interface ValueEnum<T> {
	
	/**
     * Converts value to corresponding enum.
     *  将值转化为相应的枚举
     * @param enumType enum type
     * @param value    database value
     * @param <V>      value generic
     * @param <E>      enum generic
     * @return corresponding enum
     */
	static <V, E extends ValueEnum<V>> E valueToEnum(Class<E> enumType, V value) {
		Assert.notNull(enumType, "enum type must not be null");
		Assert.notNull(value, "value must not be null");
		Assert.notNull(enumType, "enum type must not be null");
		
		return null;
		
	}
	
	
	 /**
     * Gets enum value.
     *
     * @return enum value
     */
    T getValue();

}
