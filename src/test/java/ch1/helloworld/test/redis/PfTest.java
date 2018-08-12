package ch1.helloworld.test.redis;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  HyperLogLog 使用的算法单元测试
 *  好奇心作祟   N=2^K  # 约等于
 */
public class PfTest {
    static class BitKeeper{
        private int maxBits;

        public void random(){
            long value = ThreadLocalRandom.current().nextLong(2L<<32); // 2的32次方
            int bits = lowZeros(value);
            if (bits>this.maxBits){
                this.maxBits = bits;
            }
        }

        /**
         *  获取二进制数字的低位连续0的个数
         * @param value 十进制数字
         * @return 低位连续0的个数
         * 思考: 是把这个数字右移后左移,判断是否和原来数字相等.若丢失精度.就可以判断出低位0的个数
         */
        private int lowZeros(long value){
            int i = 1;
            for(;i<32;i++){
                if(value>>i<<i!=value){
                    break;
                }
            }
            return i-1;
        }
    }

    static class Experiment{
        private int n;
        private BitKeeper bitKeeper;

        public Experiment(int n){
            this.n = n;
            this.bitKeeper = new BitKeeper();
        }

        public void work(){
            for(int i=0;i<n;i++){
                this.bitKeeper.random();
            }
        }

        /**
         * 此处用到了换底公式
         */
        public void debug(){
            System.out.printf("%d %.2f %d\n", this.n, Math.log(this.n) / Math.log(2), this.bitKeeper.maxBits);
        }
    }
    public static void main(String[] args) {
        for (int i = 1000; i < 100000; i += 100) {
            Experiment exp = new Experiment(i);
            exp.work();
            exp.debug();
        }
    }
}
