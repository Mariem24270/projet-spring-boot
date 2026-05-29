package com.donasso.gestion_dons.security;



import com.donasso.gestion_dons.entity.Don;
import com.donasso.gestion_dons.repository.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) 
            throws UsernameNotFoundException {
        
        // البحث عن المستخدم بالإيميل في قاعدة البيانات
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> 
                    new UsernameNotFoundException("Utilisateur non trouvé: " + email));

        // إعطاءه صلاحياته حسب الـ role
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
