package nayoung.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemService {

    private String name;
    private ThreadLocal<Long> price = new ThreadLocal<>();

    public void changePrice(Long price)  {
        log.info("저장: 기존 가격 = {} -> 변경 가격 = {}", this.price.get(), price);
        this.price.set(price);

        sleep(1000);

        log.info("조회: 현재 가격 = {}", this.price.get());

        this.price.remove();
        log.info("thread 삭제: 가격 = {}", this.price.get());
    }

    private void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
