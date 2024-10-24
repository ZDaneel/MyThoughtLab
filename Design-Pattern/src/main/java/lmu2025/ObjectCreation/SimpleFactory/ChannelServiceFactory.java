package lmu2025.ObjectCreation.SimpleFactory;

/**
 * @author leenadz
 * @since 2024-10-12 10:35
 */
public class ChannelServiceFactory {

    public static IChannelService create(Integer channel) {
        if(channel == 1) {
            // 条件分支不要写太复杂的逻辑。如果对象创建很麻烦，建议继续封装，静态方法或者其他手段都行
            return new TaobaoChannelService();
        } else if(channel == 2){
            return new JDChannelService();
        }
        throw new RuntimeException("渠道类型错误");
    }
}
