
# Spring Boot 학습

참고 : https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8

[https://start.spring.io/](https://start.spring.io/) → Spring Boot  initialize

[https://spring.io/projects/spring-boot#learn](https://spring.io/projects/spring-boot#learn) → Documentation

[https://www.thymeleaf.org](https://www.thymeleaf.org/) → Template Engine

Service Annoutation : @Service

Repository Annoutation : @Repository

Controller Annoutation : @Controller

Spring Bean DI

@Autowired

→ In JAVA

- 자바에서는 Contructor 구현 시 @Autowired Annoutation을 추가해줘야함

→ In Kotlin 

- 코틀린에서는 Primary Contructor 사용 시 @AutoWired Annountation 을 생략 할 수 있다
- Second Contructor 에서는 @Autowired 를 추가해야함

스프링 빈을 등록 하는 방법

1. Component Scan
2. Code로 직접 등록
3. 
1. @Component 를 포함하는 Annountation 사용 시  자동 등록
    1. @Controller
    2. @Servicer
    3. @Repository
    
2. Code로 직접 등록
    1. Configration Class 사용 ( @Configuration )
    2. @Bean Annountaion 으로 등록 (Function)
    3. Controller늘 @Component Scan 사용 가능
3. Component Scan VS Code 직접 등록
    
    DI를 통하여 기존코드 수정 없이 설정 만으로 구현 클래스르루 변경하여 사용할 수 있다
    

## Spring Integration Test

@SpringBootTest → 스프링 컨테이너와 테스트를 함께 실행

@Transaction → DB에 데이터를 남기지 않고 테스트 실행, 다음 테스트에 영향을 끼치지 않음

### JDBC / JDBC Template

### JPA

1. 반복 코드 및 SQL 코드를 생성하셔 실행
2. SQL과 데이터 중심의 설계에서 객제 중심의 설계를 할 수 있다
3. 개발 생산성을 증대 할 수 있다

 a. Entity Mapping 

→ domain 최상단에 @Entity Annountation  추가

→ 각 Field에 @Id 또는 @Collum 추가

→ Primary Key 또는 자동생성 되는 Field에는 @GeneratedValue를 사용한다

→ @Coumn 필드는 (name = ”FieldName”)을 추가한다

### Spring Data JPA

1. 특징
    - Interface 구현만으로 개발을 완료 할 수 잇음
    - CRUD 기능 제공
2. JPA Repository
    1. findAll
    2. save
    3. flush
    4. saveAndFlush
    5. deleteBatch
    6. deleteAll
    7. getOne
3. Interface 이름으로 메소드를 구현
4. 페이징 기능 자동 제공

### AOP

1. 시간을 측정하는 로직
2. 시간 측정은 공통 관심 사항 
3. 공통 로직을 만들기 어렵다
4. 측정하는 로직을 변경할 때는 모든 로직을 변경해야함
