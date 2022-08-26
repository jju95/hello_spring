package hello.hellospring.domain;


import javax.persistence.*;

@Entity
public class Member {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment처럼 db가 알아서 pk값을 올려줄때를 identity 전략이라 부름
    private Long id;

    // @Column(name = "testname") => db column name의 명칭을 소스에서 매핑시켜줄때 사용하는 어노테이션
    private  String name;

}
