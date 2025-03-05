package actual.lock;

/**
 * @author leenadz
 * @since 2024-10-26 16:07
 */
public class Account {
    // 锁：保护账户余额
    private final Object balLock
            = new Object();
    // 账户余额
    private Integer balance;
    // 锁：保护账户密码
    private final Object pwLock
            = new Object();
    // 账户密码
    private String password;

    // 取款
    void withdraw(Integer amt) {
        synchronized (balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 查看余额
    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }

    // 查看密码
    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }

    void transfer(Account target, int amt) {
        // 如果锁方法或锁this，只会锁住当前对象，而不能锁住target对象
        // 因此直接锁class对象
        synchronized (Account.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.balance = 100;
        Integer balance1 = account.getBalance();
        System.out.println("balance1: " + balance1);
        account.withdraw(10);
        Integer balance2 = account.getBalance();
        System.out.println("balance2: " + balance2);
    }
}
