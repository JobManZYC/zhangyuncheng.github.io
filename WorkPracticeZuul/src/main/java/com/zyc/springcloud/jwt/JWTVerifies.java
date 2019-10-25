package com.zyc.springcloud.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTVerifies {
    // 过期时间 24 小时
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;
    // 密钥
    private static final String SECRET = "SHIRO+JWT";
    public static boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
//    public String getToken2(HttpServletRequest request) throws Exception {
//    	   try {
//    	      Cookie[] cookies = request.getCookies();
//    	      if (cookies != null && cookies.length > 0) {
//    	         for (Cookie cookie : cookies) {
//    	            if ("token".equals(cookie.getName())) {
//    	                       String token = cookie.getValue();
//    	               HttpHeaders headers = new HttpHeaders();
//    	               RestTemplate restTemplate = new RestTemplate();
//    	               headers.put(HttpHeaders.COOKIE, Collections.singletonList("token=" + token));
//    	               HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
//    	               ResponseEntity<String> responseEntity = restTemplate.exchange(accessTokenUrl, HttpMethod.GET, requestEntity, String.class);
//    	               String body = responseEntity.getBody();
//    	               JSONObject bodyObj = JSON.parseObject(body);
//    	               Integer code = bodyObj.getInteger("code");
//    	               if (code == 200 ) {
//    	                  JSONObject object = bodyObj.getJSONObject("member");
//    	                  String uid = object.getString("uid");
//    	                  return  uid;
//    	               }
//    	               break;
//    	            }
//    	         }
//    	      }
//    	   } catch (Exception e) {
//    	      e.printStackTrace();
//    	   }
//    	   return null;
//    	}

}
