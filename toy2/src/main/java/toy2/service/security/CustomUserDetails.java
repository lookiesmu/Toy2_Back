package toy2.service.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {
	
	private Long userId;
    private String nickname;
	private String password;
    private int quiz_create;
    private List<GrantedAuthority> role= new ArrayList<GrantedAuthority>();
    
    public int getQuiz_create() {
		return quiz_create;
	}
	public void setQuiz_create(int quiz_create) {
		this.quiz_create = quiz_create;
	}
	public Long getUserId() {
		return userId;
	}
    public void setUserId(Long userId) {
    	this.userId = userId;
    }
    public String getNickname() { //db에 attribute name으로 일련의 소문자단어(ex:nickname)일 경우 get+"첫문자 대문자 이후 소문자" 로 getter, setter만들어줘야한다.
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
    
    
	
	@Override //Security 에서User 구분을 위해 사용하기위해 Userdetail로부터 상속받은 method. Security 에서 User구분 id가 된다.
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nickname;
	}
	

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

   
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }


}
