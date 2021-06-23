package cybersoft.backend.java11.gira.security.dto;

public class JwtDTO {
	private String jwt;
	
	public JwtDTO jwt(String jwt) {
		this.jwt = jwt;
		return this;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
