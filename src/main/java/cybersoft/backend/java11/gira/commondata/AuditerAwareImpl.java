package cybersoft.backend.java11.gira.commondata;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditerAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		SecurityContext currentUserSecurity = SecurityContextHolder.getContext();
		String currentUserName = currentUserSecurity.getAuthentication().getName();
		return Optional.ofNullable(currentUserName);
	}
	
}
