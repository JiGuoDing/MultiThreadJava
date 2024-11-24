// 模拟龟兔赛跑
public class Race implements Runnable {

    // 胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0 && i >= 50) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // 判断比赛是否结束
            boolean flag = isGameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " 跑了" + i  +"米");
        }
    }

    // 判断比赛是否结束
    private boolean isGameOver(int steps){
        // 判断是否有胜利者
        if(winner != null){
            // 存在胜利者，比赛结束
            return true;
        }
        if (steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
