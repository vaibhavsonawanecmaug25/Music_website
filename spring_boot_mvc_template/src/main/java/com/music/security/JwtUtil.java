//package com.music.security;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtUtil {
//	private final String SECRET = "my_secret_key_123";
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
//                .signWith(SignatureAlgorithm.HS256, SECRET)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public boolean validateToken(String token) {
//        return !isExpired(token);
//    }
//
//    private boolean isExpired(String token) {
//        Date exp = Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody()
//                .getExpiration();
//        return exp.before(new Date());
//    }
//}
//}
