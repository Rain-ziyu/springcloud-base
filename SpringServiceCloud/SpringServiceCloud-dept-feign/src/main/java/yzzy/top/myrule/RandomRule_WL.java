package yzzy.top.myrule;//package yzzy.top.myrule;
//
//import com.netflix.loadbalancer.AbstractLoadBalancerRule;
//import com.netflix.loadbalancer.ILoadBalancer;
//import com.netflix.loadbalancer.Server;
//
//import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.concurrent.atomic.AtomicInteger;
//import com.netflix.client.config.IClientConfig;
//public class RandomRule_WL extends AbstractLoadBalancerRule {
//
//    /**
//     * Randomly choose from all living servers
//     */
//    private AtomicInteger nextServerCyclicCounter;
//    private static final boolean AVAILABLE_ONLY_SERVERS = true;
//    private static final boolean ALL_SERVERS = false;
//    private int total = 0;//总被调用的次数
//    private int currentIndex = 0;//当前服务器的机器号
//    public Server choose(ILoadBalancer lb, Object key) {
//        if (lb == null) {
//            return null;
//        }
//        Server server = null;
//
//        while (server == null) {
//            if (Thread.interrupted()) {
//                return null;
//            }
//            List<Server> upList = lb.getReachableServers();
//            List<Server> allList = lb.getAllServers();
//
//            int serverCount = allList.size();
//            if (serverCount == 0) {
//                /*
//                 * No servers. End regardless of pass, because subsequent passes
//                 * only get more restrictive.
//                 */
//                return null;
//            }
//
////            int index = chooseRandomInt(serverCount);
////            server = upList.get(index);
//            if (total >= 5) {
//                total = 0;
//                int nextServerIndex = incrementAndGetModulo(serverCount);//求余
//                currentIndex = nextServerIndex;
//            }else {
//                if (currentIndex>=serverCount) {
//                    currentIndex = 0;
//                }
//                server = allList.get(currentIndex);
//                total++;
//            }
//            if (server == null) {
//                /*
//                 * The only time this should happen is if the server list were
//                 * somehow trimmed. This is a transient condition. Retry after
//                 * yielding.
//                 */
//                Thread.yield();
//                continue;
//            }
//
//            if (server.isAlive()) {
//                return (server);
//            }
//
//            // Shouldn't actually happen.. but must be transient or a bug.
//            server = null;
//            Thread.yield();
//        }
//
//        return server;
//
//    }
//
//    /**
//     * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}.
//     *
//     * @param modulo The modulo to bound the value of the counter.
//     * @return The next value.
//     */
//    private int incrementAndGetModulo(int modulo) {
//        for (;;) {
//            int current = nextServerCyclicCounter.get();
//            int next = (current + 1) % modulo;
//            if (nextServerCyclicCounter.compareAndSet(current, next)) {
//                return next;
//            }
//        }
//    }
//
//
//    @Override
//    public Server choose(Object key) {
//        return choose(getLoadBalancer(), key);
//    }
//
//    @Override
//    public void initWithNiwsConfig(IClientConfig iClientConfig) {
//
//    }
//}
//
