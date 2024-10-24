package lmu2025.ObjectCreation.SimpleFactory;

/**
 * @author leenadz
 * @since 2024-10-12 10:36
 */
public class JDChannelService implements IChannelService {
    @Override
    public void createOrder() {
        System.out.println("京东下单");
    }
}
