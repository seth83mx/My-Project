package com.metaphorce.commons.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PscUserDTO implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;
	private byte[] cerFile;
	private byte[] keyFile;
	
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	Collection<? extends GrantedAuthority> authorities;
		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getCerFile() {
		return cerFile;
	}
	public void setCerFile(byte[] cerFile) {
		this.cerFile = cerFile;
	}
	public byte[] getKeyFile() {
		return keyFile;
	}
	public void setKeyFile(byte[] keyFile) {
		this.keyFile = keyFile;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	    public String toString() {
	        StringBuilder builder = new StringBuilder();
	        builder.append("User [username=");
	        builder.append(username);
	        builder.append(", password=");
	        builder.append(password);
	        builder.append(", cerFile=");
	        builder.append(cerFile);
	        builder.append(", keyFile=");
	        builder.append(keyFile);
	        builder.append(", authorities=");
	        builder.append(authorities);
	        builder.append(", accountNonExpired=");
	        builder.append(accountNonExpired);
	        builder.append(", accountNonLocked=");
	        builder.append(accountNonLocked);
	        builder.append(", credentialsNonExpired=");
	        builder.append(credentialsNonExpired);
	        builder.append(", enabled=");
	        builder.append(enabled);
	        builder.append("]");
	        return builder.toString();
	    }
	
}
