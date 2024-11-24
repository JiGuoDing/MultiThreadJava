/**
 * 静态代理
 * 以结婚为示例
 * 你 -> 真实角色
 * 婚庆公司 -> 代理你，帮你准备结婚事宜
 * 结婚 -> 实现都实现结婚接口即可
 */

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new Man());
        weddingCompany.marry();
    }
}

interface Marry {
    void marry();
}

/**
 * 真实角色
 */
class Man implements Marry {
    @Override
    public void marry() {
        System.out.println("秦老师要结婚了");
    }
}

/**
 * 婚庆公司
 */
class WeddingCompany implements Marry {

    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void marry() {
        before();
        this.target.marry();
        after();
    }

    private void before(){
        System.out.println("结婚前布置场景");
    }
    private void after(){
        System.out.println("结婚后收尾款");
    }
}
