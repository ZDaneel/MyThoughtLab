package lmu2025.ObjectCreation.SimpleFactory;

/**
 * @author leenadz
 * @since 2024-10-12 10:35
 */
public class TaobaoChannelService implements IChannelService {
    @Override
    public void createOrder() {
        System.out.println("淘宝下单");
    }
}
