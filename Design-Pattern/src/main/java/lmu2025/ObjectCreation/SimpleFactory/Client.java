package lmu2025.ObjectCreation.SimpleFactory;

/**
 * @author leenadz
 * @since 2024-10-12 10:36
 */
public class Client {
    public void method(Integer channel) {
        // 依赖工厂，而非具体实现
        IChannelService channelService = ChannelServiceFactory.create(channel); // 就可以根据传入的参数创建不同的对象
        // 使用channelService
        channelService.createOrder();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.method(1);
        client.method(2);
    }
}
