package user.service.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import user.service.UserService;
import user.service.dto.request.SignupRequestDto;

@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class HomeController {
	private final UserService userService;
	@ResponseBody
	@PostMapping("signup")
	public ResponseEntity<String> signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
		userService.signup(signupRequestDto);
		return ResponseEntity.ok("OK");
	}
	@GetMapping("/user/oauth2/authorization/naver")
	public RedirectView redirectToNaverOAuth() {
		return new RedirectView("/oauth2/authorization/naver");
	}
}