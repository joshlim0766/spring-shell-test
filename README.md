# spring-shell-test

* Spring Shell(https://projects.spring.io/spring-shell) 을 이용하여 모드를 지원하는 CLI 구현을 위한 간단한 테스트 구현
* org.springframework.shell.Shell class의 listCommands()로 얻어올 수 있는 커맨드 정보들을 런타임에 마음대로 넣고 뺄 수 있다는 점을 이용
* NodeManagerService가 초기화된 후 CommandRegistryHelper class를 이용하여 전체 커맨드 정보는 별도 보관한 후 초기 CLI 모드에서 필요한 커맨드만 노출할 수 있도록 구현하였음
* 특정 모드로 진입하는 커맨드를 실행하였을 때 NodeManagerService의 changeNode()를 이용하여 CommandRegistry가 보유하고 있는 커맨드를 재구성하는 방식으로 구현하였음
