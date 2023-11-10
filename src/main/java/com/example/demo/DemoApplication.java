package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
해당 클래스는 앞으로 만들 프로젝트의 메인 클래스
@SpringBootApplication 으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
특히 @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치
*/

@EnableJpaAuditing
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		// 해당 run 메소드를 통해서 내장 WAS를 실행 <- 항상 톰캣을 설치할 필요할 필요가 없게 되고, Jar 파일로 실행하면 됨
		// 외장 WAS를 사용한다면 모든 서버가 WAS의 종류와 버전, 설정을 일치시켜야하므로 실수할 여지도 많고, 시간도 오래 걸리게 됨
		SpringApplication.run(DemoApplication.class, args);
	}
}
