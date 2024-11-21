//package org.example.myPractice.Cognito;
//import com.amazonaws.services.cognitoidp.AmazonCognitoIdentityProvider;
//import com.amazonaws.services.cognitoidp.AmazonCognitoIdentityProviderClientBuilder;
//import com.amazonaws.services.cognitoidp.model.*;
//
//public class CognitoExample {
//    public static void main(String[] args) {
//        AmazonCognitoIdentityProvider cognitoClient = AmazonCognitoIdentityProviderClientBuilder.standard().build();
//
//        // 创建用户
//        AdminCreateUserRequest createUserRequest = new AdminCreateUserRequest()
//                .withUserPoolId("<user-pool-id>")
//                .withUsername("<username>");
//        cognitoClient.adminCreateUser(createUserRequest);
//
//        // 登录用户
//        InitiateAuthRequest authRequest = new InitiateAuthRequest()
//                .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
//                .withClientId("<app-client-id>")
//                .addAuthParametersEntry("USERNAME", "<username>")
//                .addAuthParametersEntry("PASSWORD", "<password>");
//        InitiateAuthResult authResult = cognitoClient.initiateAuth(authRequest);
//
//        // 获取用户信息
//        GetUserRequest getUserRequest = new GetUserRequest()
//                .withAccessToken("<access-token>");
//        GetUserResult getUserResult = cognitoClient.getUser(getUserRequest);
//
//        // 更新用户属性
//        AdminUpdateUserAttributesRequest updateUserAttributesRequest = new AdminUpdateUserAttributesRequest()
//                .withUserPoolId("<user-pool-id>")
//                .withUsername("<username>")
//                .withUserAttributes(new AttributeType().withName("custom:attribute").withValue("value"));
//        cognitoClient.adminUpdateUserAttributes(updateUserAttributesRequest);
//        // 获得用户凭证
//        GetOpenIdTokenRequest request = new GetOpenIdTokenRequest()
//                .withIdentityId("<identity-id>")
//                .addLoginsEntry("<provider>", "<token>");
//        GetOpenIdTokenResult result = cognitoClient.getOpenIdToken(request);
//
//        System.out.println("OpenID Token: " + result.getToken());
//    }
//}
