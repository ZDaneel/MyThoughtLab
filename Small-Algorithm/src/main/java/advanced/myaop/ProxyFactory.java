package advanced.myaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author leenadz
 * @since 2024-10-12 09:52
 */
public class ProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LogInvocationHandler(target)
        );
    }

    private record LogInvocationHandler(Object target) implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("method: " + method);
            System.out.println("args: " + Arrays.toString(args));

            Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
            System.out.println("targetMethod: " + targetMethod);

            if (targetMethod.isAnnotationPresent(Loggable.class)) {
                System.out.println(method.getName() + "方法开始执行...");
                Object result = method.invoke(target, args);
                System.out.println("结果: " + result);
                System.out.println(method.getName() + "方法执行结束...");
                return result;
            }

            return method.invoke(target, args);
        }
    }
}
