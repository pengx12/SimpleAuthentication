## A simple authentication and authorization service

The service allows users to be authenticated, and authorizes different behavior.

### Run the test

All the test files are in the test.java.com.example.service, which can be run to test the function.

### Main Services
The project implement four services to achieve the main functions, which can be tested in the test package.
#### UserService
Implements the APIs manipulating the users like create or delete user. The functions can be tested by running the UserServiceTest.

        boolean addUser(String username, String password)
        boolean deleteUser(String username, TokenPool tokenpool)
#### RoleService
Implements the APIs manipulating the users like create or delete roles. The functions can be tested by running the RoleServiceTest.

         boolean addRole(String name);
         boolean deleteRole(String name);

#### AuthenticateService
Implements the APIs of authentication. The token is producedin the service. The functions can be tested by running the AuthenticateServiceTest.

    String authenticate(String username, String password);
    void invalidate(String token);

#### CheckRoleService
Implements the APIs to add or check the relationship between roles and users. The expiration of token is also checked in the service. The functions can be tested by running the CheckRoleServiceTest.

    void addRoletoUser(String username, String rolename);
    boolean checkRole(String token, Role role);
    HashSet<Role> getAllRoles(String token);


