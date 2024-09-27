package atguigu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * @author leenadz
 * @since 2024-09-27 14:10
 */
public class TestCallable {
    public static void main(String[] args) {
        ThreadCall threadCall = new ThreadCall();
        FutureTask<String> result = new FutureTask<>(threadCall);
        new Thread(result).start();
        try {
            String s = result.get();
            System.out.println("----------------");
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadCall implements Callable<String> {

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(sb);
            sb.append(i);
        }
        sleep(2000);
        return sb.toString();
    }
}
