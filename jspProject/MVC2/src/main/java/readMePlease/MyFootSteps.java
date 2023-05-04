package readMePlease;


public class MyFootSteps {
}

// 2023-05-04: 나의 다이나믹 Toy Project의 기록 시작 
// 기록 시작의 이유 -> 여러 가지의 문제점에 부딪히며 기술적으로 해결한 문제나 오류, 또한 
// 로직 분리의 고민이 있었지만, 여태 해결하기 급급했고 발자취를 남긴다는 생각을 할 수가 없었다. 
// 면접관의 입장에서는 면접자의 발자취를 본다는 것은 이 면접자가 얼마나 고민의 시간을 가져왔고, 
// 또한 그 고민을 통해 어떤 공부를 했고 어떤 기술을 배웠는지를 보는 것이 면접자를 판단할 수 있는 
// 중요한 요소가 될 수 있다고 생각하여 만들기 시작한다.


// 2023-05-04: 나의 다이나믹 Toy Project 기록
// 2023-05-03부터 로그인시에 이메일 인증을 하고 회원 가입이 되게 만들고 싶었다.
// 꿈에서도 코딩을 고민했더니 생각해낸 결과는 -> 클라이언트가 createUser.jsp에서 회원가입 요청 버튼을 누르면
// createUserController는 userService.EmailVerifyCode로 유저의 정보를 전달한다.
// UserService의 로직에서는 authCode = EmailServiceVerifyCode.getInstance().sendEmailVerifyCode(user);
// 이 로직을 통해 난수를 EmailServiceVerfiycode의 클래스에서 생성해 보내게 하였다.
// 모든 동작이 이루어지면 waiting.jsp로 이동을하고 waiting.jsp는 클라이언트의 세션 정보를 전부 가지고 있게 하였다.
// 또한 인증번호를 잘못 입력할 시에 계속 waiting.jsp에 머무르게 하였으며, 클라이언트가 회원가입의 의지가 떨어져
// 강제 종료 X 버튼을 누르면 가입 절차가 이루어지지 않게 VerifyCodeController 내에서
// 인증 코드가 일치할 시에만 userService.createTestUser로 클라이언트의 정보를 보내게 하였으며,
// main.jsp 로 리다이렉트하며 waiting.jsp에 있던 세션을 가져오고 지워야 함으로 session.invalidate()를 썼다.
// userService.createTeestUser로 user의 객체가 전달이 되면 userService.createTestUser 로직은
// welcome 이메일을 발송한다


// 2023-05-04: 나의 다이나믹 Toy Project 기록
// 오후 1시 47분경 든 생각
// 이전에 LoginController에서 로그인 시에 checkBox를 누르면 쿠키가 생성되어 5개월 동안
// ID를 기억하여 자동 로그인이 되게 만들었고, 재 로그인 시에 checkBox를 해제하면 쿠키가 삭제되게 만들었다.
// 이제 세션을 보내주고 삭제하는 클래스와 쿠키를 보내주고 삭제하는 클래스를 만들면 로직이 분리될 것이다.
// 이는 MVC 패턴의 가장 큰 장점인 비즈니스 로직과 뷰의 로직이 분리되어 유지보수가 쉬워지기 위함이라고 생각한다.
// 그래서 Controller에서도 로직을 분리하여 메소드만 호출하면 어떨까? 라는 생각을 하게 되었고, 이를 구현해 보려고 한다.




