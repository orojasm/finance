# Change Log

## Close 

### Pull Request # 1 Feat/config - Initial configurations
* Date: 2025/03/27
* Autor: Oscar Rojas
* Status: `Close`
* Disabling Spring Security
* Installing MapStruct 

### Pull request #3 Feat/payment - Implement initial feature Payments
* Date: 2025/03/28
* Autor: Oscar Rojas
* Status: `Close`
* Basic implementation of payment domain models
* Basic implementation of payment services
* Basic implementation of payment persistence
* Implementation of payment rest controllers
* And Documentations


## Open

### `TODO` - `LOW` - Implement Spring Security
  * Date: 2025/03/27
  * In Memory User Details Manager
  * Filter Implement
    * authorizeHttpRequests
    * httpBasic
    * formLogin
  * Implement GET User
  * Define User Mockup
  * Implement Filter, 
  * Enable Spring Security

### `TODO` - `LOW` - Create user validation
  * Date: 2025/04/10
  * Verify that when creating a user, no roles are sent in the request

### `ERROR` - `LOW` - **IDs don't match:**
  * Date: 2025/03/28
  * In the PUT endpoint, you must validate that the parameter id and the body match.

### `ERROR` - `LOW`- **Delete does not display the result:**
  * Date: 2025/03/28
  * The DELETE endpoint must be answered whether I delete the record or not,
  * 