package hello.hellospring.domain; //회원, 주문, 쿠폰 등 주로 데이터베이스에 저장하고 관리됨

public class Member {

    private long id;
    private String name;

    public long getId() { //꺼내 받을 때 씀
        return id;
    }

    public void setId(long id) { //저장할 때 씀
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
