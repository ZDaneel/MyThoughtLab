package advanced.myaop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author leenadz
 * @since 2024-10-12 09:51
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // can be used only on methods
public @interface Loggable {
}
