package com.fiee.fieeblog.config;

/**
 * @Author: Fiee
 * @ClassName: WebSecurity * @Date: 2023/2/24
 * @Version: v1.0.0
 **/
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled = true,securedEnabled = true)
public class WebSecurityConfig {
//    @Bean
//    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
//        return new FilterInvocationSecurityMetadataSourceImpl();
//    }
//    @Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//    @Bean
//    public AccessDecisionManager accessDecisionManager() {
//        return new AccessDecisionManagerImpl();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//        http.formLogin();
//
//        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
//                        object.setSecurityMetadataSource(securityMetadataSource());
//                        object.setAccessDecisionManager(accessDecisionManager());
//                        object.setRejectPublicInvocations(false);
//                        return object;
//                    }
//                })
//                .anyRequest()
//                .permitAll()
//                .and()
//                // 关闭跨站请求防护
//                .csrf().disable().exceptionHandling()
//                .and()
//                .sessionManagement()
//                .maximumSessions(20)
//                .sessionRegistry(sessionRegistry());
//
//
//        return http.build();
//    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/static/**");
//    }
}
