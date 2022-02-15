package nayoung.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemService {

    private String name;
    private Long price;

    public void changePrice(Long price)  {
        log.info("저장: 기존 가격 = {} -> 변경 가격 = {}", this.price, price);
        this.price = price;

        sleep(1000);

        log.info("조회: 현재 가격 = {}", this.price);
    }

    private void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
